 jQuery.noConflict();

        mlBrowser = {
            node: null,
            site: null,
            path: [],
            lastSearchText: null,
            lastSearchResult: null,
            mlSvc: function ($, obj) {
                var fnSuccess = obj.success;
                var fnError = obj.error;
                if (obj == undefined || obj.url == undefined)
                    throw "Parametro url obligatorio.";
            obj.url = "https://api.mercadolibre.com/" + obj.url;
            obj.dataType = "jsonp";
            obj.success = function (data, textStatus, jqXHR) {
                if (data != null && data.length == 3 && data[0] >= 200 && data[0] <= 299) {
                    if (fnSuccess != undefined) {
                        var objData = data[2];
                        fnSuccess(objData, data, textStatus, jqXHR);
                    }
                } else {
                    if (fnError != undefined)
                        fnError(jqXHR, "mlerror", data);
                }
            },
            obj.error = function (jqXHR, textStatus, errorThrown) {
                if (fnError != undefined)
                    fnError(jqXHR, textStatus, errorThrown);
            },
            $.ajax(obj);
        },
        defaultErrorBehavior: function ($, jqXHR, textStatus, errorThrown) {
            alert("Error" + (textStatus == "mlerror" ? " de ML: " + errorThrown[2].message : " en la aplicacion."));
        },
        PaisesFill: function ($) {
            var me = this;
            me.mlSvc($, { url: "sites",
                success: function (sites) {
                    $(".paises", me.node).html("<div class='combo'><span class='site'></span><ul class='lista'></ul></div>");
                    var combo = $(".paises .combo", me.node);
                    var lista = $(".paises .lista", me.node);
                    lista.html("");
                    $(sites).each(function () {
                        var site = this;
                        lista.append('<li><a href="#">' + site.name + "</a></li>");
                        $("a:last", lista).click(function () { me.SiteChanged($, site); });
                    });
                    me.SiteChanged($, sites[0]);
                    combo.dropdown();
                },
                error: function (jqXHR, textStatus, errorThrown) {
                    me.defaultErrorBehavior($, jqXHR, textStatus, errorThrown);
                }
            });
        },
        SiteChanged: function ($, site) {
            var me = this;
            me.mlSvc($, { url: "sites/" + site.id,
                success: function (siteInfo) {
                    me.site = siteInfo;
                    $(".paises .site", me.node).html(siteInfo.name + '<span class="ico">drop</span>');
                    me.CategoriesFill($, siteInfo.categories);
                    me.PathChange($, []);
                },
                error: function (jqXHR, textStatus, errorThrown) {
                    me.defaultErrorBehavior($, jqXHR, textStatus, errorThrown);
                }
            });
        },
        CategoriesFill: function ($, categories) {
            var me = this;
            var lista = $(".categories ul", me.node);
            lista.html("");
            $(categories).each(function () {
                var category = this;
                lista.append('<li><a href="#">' + category.name + "</a></li>");
                $("a:last", lista).click(function () { me.CategoryChange($, category); });
            });
        },
        PathChange: function ($, path) {
            var me = this;
            var pathText = $(".path", me.node);
            var items = $(".items ul", me.node);
            pathText.html("");
            items.html("");
            $(".items .itemsCount", me.node).html("");
            me.path = path;
            $(path).each(function (index) {
                var category = this;
                pathText.append('<a href="#">' + this.name + '</a>');
                $("a:last", pathText).click(function () { me.CategoryChange($, category); });
                if (index < path.length - 1)
                    pathText.append(" > ");
            });
        },
        CategoryChange: function ($, category) {
            var me = this;
            me.mlSvc($, { url: "categories/" + category.id,
                success: function (categoryInfo) {
                    me.CategoriesFill($, categoryInfo.children_categories);
                    me.PathChange($, categoryInfo.path_from_root);
                    me.Search($, "");
                },
                error: function (jqXHR, textStatus, errorThrown) {
                    me.defaultErrorBehavior($, jqXHR, textStatus, errorThrown);
                }
            });
        },
        ItemsFill: function ($, results) {
            var me = this;
            var listado = $(".items .listado", me.node);
            $(".items .itemsCount", me.node).html("(" + me.lastSearchResult.paging.total.toString() + " resultados totales)");
            listado.html("");
            $(results).each(function () {
                var item = this;
                me.RenderItem($, listado, item);
            });
        },
        RenderItem: function ($, listado, item) {
            var me = this;
            listado.append("<li><img /><h1></h1><h2></h2></li>");
            var li = $("li:last", listado);
            $("img", li).attr("src", item.thumbnail);
            $("h1", li).html(item.price + " " + item.currency_id);
            $("h2", li).html(item.title.substring(0, 30) + (item.title.length > 29 ? "..." : ""));
            li.layer({
                content: "<div class='layer'>" + item.title + "<br />" + item.subtitle + "<br /><a target='_blank' href='" + item.permalink + "'>(ir a mercadolibre)</a></div>",
                offset: "0 -30"
            });
        },
        
        Search: function ($, texto) {
            var me = this;
            var query = "";
            if (texto.length > 0) {
                query = "q=" + texto;
            }
            if (me.path.length > 0) {
                //filtrar por categoria
                query += (texto.length > 0 ? "&" : "") + "category=" + me.path[me.path.length - 1].id;
            }
            var url = "sites/" + me.site.id + "/search?" + query;
            me.mlSvc($, { url: url,
                success: function (searchResult) {
                    me.lastSearchText = "";
                    me.lastSearchResult = searchResult;
                    me.ItemsFill($, searchResult.results);
                },
                error: function (jqXHR, textStatus, errorThrown) {
                    me.defaultErrorBehavior($, jqXHR, textStatus, errorThrown);
                }
            });
        },
        SearchClick: function ($, texto) {
            var me = this;
            if (texto.length > 0) {
                me.Search($, texto);
            }
        }
    }

    jQuery.fn.mlBrowserInit = function () {
        for (var i = 0; i < this.length; i++) {
            var _ml = {};
            jQuery.extend(_ml, {}, mlBrowser);
            _ml.node = this[i];
            _ml.PaisesFill(jQuery);
            jQuery(".mlBtnSearch", _ml.node).click(function () {
                _ml.SearchClick(jQuery, jQuery(".mlTxtSearch", _ml.node).val());
            });
        }
        return this;
    };

    jQuery(function ($) {
        $("#ml").mlBrowserInit();
    });