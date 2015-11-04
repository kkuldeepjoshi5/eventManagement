/**
 * ! easyPieChart Lightweight plugin to render simple, animated and retina
 * optimized pie charts
 * 
 * @license
 * @author Robert Fleischmann <rendro87@gmail.com>
 *         (http://robert-fleischmann.de)
 * @version 2.1.5
 */

/**
 * uiBreadcrumbs automatic breadcrumbs directive for AngularJS & Angular ui-router.
 *
 * https://github.com/michaelbromley/angularUtils/tree/master/src/directives/uiBreadcrumbs
 *
 * Copyright 2014 Michael Bromley <michael@michaelbromley.co.uk>
 */

(function(e){"use strict";e("app-ctrl",[],function(){var e=function(e,t,n,r,i,s,o,u,a,f,l,c){function p(){h>3&&(h=1),e.url="url('images/back"+h+".jpg')  no-repeat border-box",e.style={background:e.url,"background-size":"cover"},h+=1}e.notifications=f,e.breadcrumbs=a,e.$on("$routeChangeError",function(e,t,n,r){f.pushForCurrentRoute("errors.route.changeError","danger",{},{rejection:r})}),u.innerWidth<600&&(e.isMobile=!0),e.$watch(function(){return u.innerWidth},function(t){t<600?e.isMobile=!0:e.isMobile=!1},!0),e.removeNotification=function(e){f.remove(e)},e.redirect=function(e){n.path(e)},e.getTableStyle=function(e){var t=30,n=35;return e==null||e===undefined&&e.length===0?{height:"0px"}:{height:e.length*t+n+"px"}};var h=1;p(),r(p,8e3),e.setBG=function(t){e.home="",e.gallery="",e.about="",e.contact="",e.event="",e.service="",e.profile="";switch(t){case"/home":e.home="back-color";break;case"/gallery":o.get("./dataFile/gallery.json").success(function(t){e.pics=angular.copy(t.pics)}).error(function(e){alert("error")}),e.gallery="back-color";break;case"/about":e.about="back-color";break;case"/contact":e.contact="back-color";break;case"/event":e.event="back-color";break;case"/ourService":e.service="back-color";break;case"/profile":e.profile="back-color";break;default:n.path("/home"),e.home="back-color"}},e.setBG(n.$$path)};return["$scope","$rootScope","$location","$interval","$timeout","$interpolate","$http","$window","breadcrumbs","i18nNotifications","logoutTimer","cfpLoadingBar",e]})})(define),function(e){"use strict";e("common/header/header-ctrl",[],function(){var e=function(e,t,n,r){r.start(),e.mainMenuList=[],e.moreMenuList=[],e.incLength=function(){angular.element("#advSearch").animate({width:"250px"})},e.decLength=function(){angular.element("#advSearch").animate({width:"150px"})},e.getHeaderInfo=function(){t.get("/rest/general/getHeaderInfo").success(function(t){e.currentUser=t.appUser,e.initialLoggedUser=t.initialLoggedUser,e.currentAcdYearName=t.currentSelectedAcademicYear,e.currentAcdYearKey=t.currentSelectedAcademicYearKey,e.acdYearList=t.acdYearList,e.currentAcdYearUnitName=t.currentSelectedAcademicYearUnit,e.currentAcdYearUnitKey=t.currentSelectedAcademicYearUnitKey,e.acdYearUnitList=t.acdYearUnitList,e.mainMenuList=t.mainMenuList,e.moreMenuList=t.moreMenuList,e.headerTitle=t.headerTitle,e.selectedAcademicYearKey=e.currentAcdYearKey,e.selectedAcademicYearUnitKey=e.currentAcdYearUnitKey}),console.log("header")},e.getHeaderInfo(),e.setDataContext=function(){console.log("yes"),n.location.href="/rest/setDataContext?acadYear="+e.selectedAcademicYearKey+"&acadYearUnit="+e.selectedAcademicYearUnitKey},e.setAcademicYear=function(t){console.log(t),t!=undefined&&t!=null&&(e.selectedAcademicYearKey=t,e.setDataContext())},e.setAcademicYearUnit=function(t){console.log(t),t!=undefined&&t!=null&&(e.selectedAcademicYearUnitKey=t,e.setDataContext())}};return["$scope","$http","$window","cfpLoadingBar",e]})}(define),function(e){"use strict";e("common/header/header-module",["common/header/header-ctrl"],function(e){var t="header";return angular.module(t,["chieffancypants.loadingBar","ngAnimate"]).controller("HeaderCtrl",e),t})}(define),function(e){"use strict";e("common/loading",[],function(){var e="services.loading",t=angular.module(e,[]);return t.factory("loadingService",function(){var e={requestCount:0,isLoading:function(){return e.requestCount>0}};return e}),t.factory("onStartInterceptor",["loadingService",function(e){return function(t,n){return e.requestCount++,t}}]),t.factory("delayedPromise",["$q","$timeout",function(e,t){return function(n,r){var i=e.defer(),s=function(){t(function(){i.resolve(n)},r)};return n.then(s,s),i.promise}}]),t.factory("onCompleteInterceptor",["loadingService","delayedPromise","$location",function(e,t,n){return function(t){var r=function(t){return e.requestCount--,t},i=function(t){return e.requestCount--,t.status==401?window.location.assign("logout.do"):n.path("error"),t};return t.then(r,i)}}]),t.config(["$httpProvider",function(e){e.responseInterceptors.push("onCompleteInterceptor")}]),t.run(["$http","onStartInterceptor",function(e,t){e.defaults.transformRequest.push(t)}]),t.controller("LoadingCtrl",["$scope","loadingService",function(e,t){e.$watch(function(){return t.isLoading()},function(t){e.loading=t})}]),e})}(define),function(e){"use strict";e("common/directives/tree",[],function(){var e="directives.tree";return angular.module(e,[]).directive("tree",function(){return{restrict:"E",templateUrl:"app/common/tree.tpl.html"}}).directive("csttree",function(){return{restrict:"E",templateUrl:"app/common/csttree.tpl.html"}}),e})}(define),function(e){"use strict";e("common/directives/collapsetab",[],function(){var e="directives.collapsetab";return angular.module(e,[]).directive("collapsetab",function(){return{restrict:"E",templateUrl:"app-ace/common/collapsetab.tpl.html"}}),e})}(define),function(e){"use strict";e("common/directives/slider",[],function(){var e="directives.slider";return angular.module(e,[]).directive("slider",function(){return{restrict:"AE",replace:!0,scope:{images:"="},link:function(e,t,n){var r=5,i=0;e.selectedIndex=2,e.setIndex=function(t){e.selectedIndex=t,e.selectedImage=e.rail[e.selectedIndex]},e.selectedImage=e.images[i+2],e.currentIndex=0,e.rail=[],e.$watch("images",function(){for(var t=0;t<6;t++)e.images[t]!=null&&e.rail.push(e.images[t]);e.selectedImage=e.images[e.selectedIndex]}),e.next=function(){i==e.images.length-1?i=0:i++,r<e.images.length-1?r++:r==e.images.length-1&&(r=0),e.rail.splice(0,1),e.rail.push(e.images[r]),e.selectedImage=e.rail[e.selectedIndex]},e.prev=function(){r==0?r=e.images.length-1:r--,i>0?i--:i==0&&(i=e.images.length-1,r=i-6),e.rail.splice(5,1),e.rail.unshift(e.images[i]),e.selectedImage=e.rail[e.selectedIndex]}},templateUrl:"app/common/templates/slider.html"}}),e})}(define),function(e){"use strict";e("common/config-manager",[],function(){var e=function(e,t,n){n.useStaticFilesLoader({prefix:"notification/message-",suffix:".json"}),n.uses("en-in"),t.html5Mode(!1)};return["$stateProvider","$locationProvider","$translateProvider",e]})}(define),function(e){"use strict";e("common/run-manager",[],function(){var e=function(e,t,n,r,i,s){t.$on("$viewContentLoaded",function(){sessionStorage.setItem("flag","0"),localStorage.setItem("count","0");var e=s(function(){document.readyState==="complete"&&(window.scrollTo(0,0),s.cancel(e))},200)})};return["$window","$rootScope","$location","$state","$timeout","$interval",e]})}(define),function(e){"use strict";e("common/services/breadcrumbs",[],function(){var e=function(e,t){var n=[],r={};return e.$on("$stateChangeSuccess",function(e,r){var i=t.path().split("/"),s=[],o,u=function(e){return i.slice(0,e+1).join("/")};i.shift();var a={};for(o=0;o<i.length;o++){var f=i[o].charAt(0).toUpperCase()+i[o].substring(1),l={name:f.replace("-"," ","g"),path:u(o)},c=parseInt(l.name,10);c>0?a.path=l.path:(s.push(l),a=l)}n=s}),r.getAll=function(){return n},r.getFirst=function(){return n[0]||{}},r};return["$rootScope","$location",e]})}(define),function(e){"use strict";e("common/services/notifications",[],function(){var e=function(e,t){var n={STICKY:[],ROUTE_CURRENT:[],ROUTE_NEXT:[]},r={},i=function(e,t){if(!angular.isObject(t))throw new Error("Only object can be added to the notification service");return e.push(t),t};return e.$on("$routeChangeSuccess",function(){n.ROUTE_CURRENT.length=0,n.ROUTE_CURRENT=angular.copy(n.ROUTE_NEXT),n.ROUTE_NEXT.length=0}),r.getCurrent=function(){return[].concat(n.STICKY,n.ROUTE_CURRENT)},r.pushSticky=function(e){return i(n.STICKY,e)},r.pushForCurrentRoute=function(e){var t=i(n.ROUTE_CURRENT,e);return e.type==="success"?r.removeAuto(e,5e3):e.type==="warning"&&r.removeAuto(e,7e3),t},r.pushForNextRoute=function(e){var t=i(n.ROUTE_NEXT,e);return e.type==="success"?r.removeAuto(e):e.type==="warning"&&r.removeAuto(e,5e3),t},r.removeAuto=function(e,i){if(i===undefined||i==null)i=3e3;t(function(){var e=n.ROUTE_CURRENT;angular.forEach(e,function(e){r.remove(e)})},i)},r.remove=function(e){angular.forEach(n,function(t){var n=t.indexOf(e);n>-1&&t.splice(n,1)})},r.removeAll=function(){angular.forEach(n,function(e){e.length=0})},r};return["$rootScope","$timeout",e]})}(define),function(e){"use strict";e("common/services/localizedMessages",[],function(){var e=function(e,t){var n=function(e,t){return e||"?"+t+"?"};return{get:function(r,i){var s=t(r);return s?e(s)(i):n(s,r)}}};return["$interpolate","$translate",e]})}(define),function(e){"use strict";e("common/services/i18nNotifications",[],function(){var e=function(e,t){var n=function(t,n,r,i){return angular.extend({message:e.get(t,r),type:n},i)},r={pushSticky:function(e,r,i,s){return t.pushSticky(n(e,r,i,s))},pushForCurrentRoute:function(e,r,i,s){return t.pushForCurrentRoute(n(e,r,i,s))},pushForNextRoute:function(e,r,i,s){return t.pushForNextRoute(n(e,r,i,s))},getCurrent:function(){return t.getCurrent()},remove:function(e){return t.remove(e)},removeAll:function(e){return t.removeAll()}};return r};return["localizedMessages","notifications",e]})}(define),function(e){"use strict";e("common/services/rest-resource",[],function(){var e=function(e,t){function n(n,r){var i=n,s=r,o=function(e,n,r,i){var s=n||angular.noop,o=r||angular.noop;return e.then(function(e){var n;if(i){n=[];for(var r=0;r<e.data.length;r++)n.push(new u(e.data[r]))}else{if(e.data===" null ")return t.reject({code:"resource.notfound"});n=new u(e.data)}return s(n,e.status,e.headers,e.config),n},function(e){return o(undefined,e.status,e.headers,e.config),undefined})},u=function(e){angular.extend(this,e)};return u.all=function(e,t){return u.query({},e,t)},u.httpPromise=function(e,t,n,r){if(r===undefined||r==null)r=!0;return o(e,t,n,r)},u.query=function(t,n,r){var u=angular.isObject(t)?{q:JSON.stringify(t)}:{},a=e.get(i,{params:angular.extend({},s,u)});return o(a,n,r,!0)},u.getById=function(t,n,r,u,a,f){var l="";t!==""?l=i+t+"/"+r+n:l=i+r+n;var c=e.get(l,{params:s});return o(c,u,a,f)},u.getByIds=function(e,t,n){var r=[];return angular.forEach(e,function(e){r.push({$oid:e})}),u.query({_id:{$in:r}},t,n)},u.prototype.$id=function(){if(this._id&&this._id.$oid)return this._id.$oid},u.prototype.$save=function(t,n,r,u,a){var f=e.post(i+t+n,r,{params:s});return o(f,u,a)},u.prototype.$update=function(t,n,r,u,a,f){var l=e.put(i+t+"/"+r+n,u,{params:s});return o(l,a,f)},u.prototype.$remove=function(t,n,r,u,a){var f=e["delete"](i+t+"/"+r+n,{params:s});return o(f,u,a)},u.prototype.$saveOrUpdate=function(e,t,n,r){return this.$id()?this.$update(t,r):this.$save(e,n)},u}return n};return["$http","$q",e]})}(define),function(e){"use strict";e("common/services/logout-timer",[],function(){var e=function(e,t,n,r,i){var s={};return localStorage.metaCampusLastAccessTime=(new Date).getTime(),n.started=!1,n.closeModals=function(){n.warning&&(n.warning.close(),n.warning=null),n.timedout&&(n.timedout.close(),i.location.href="/logout.do",n.timedout=null)},n.$on("$idleStart",function(){n.closeModals(),n.warning=t.open({templateUrl:"warning-dialog.html",windowClass:"modal-danger"})}),n.$on("$idleEnd",function(){n.closeModals()}),n.$on("$idleTimeout",function(){n.closeModals(),n.timedout=t.open({templateUrl:"timedout-dialog.html",windowClass:"modal-danger"})}),n.startNgIdlemodule=function(){n.closeModals(),e.watch(),n.started=!0},n.stopNgIdlemodule=function(){n.closeModals(),e.unwatch(),n.started=!1},document.addEventListener("keyup",function(){n.$apply(function(){localStorage.metaCampusLastAccessTime=(new Date).getTime()})}),document.addEventListener("click",function(){n.$apply(function(){localStorage.metaCampusLastAccessTime=(new Date).getTime()})}),document.addEventListener("DOMMouseScroll",function(){n.$apply(function(){localStorage.metaCampusLastAccessTime=(new Date).getTime()})}),document.addEventListener("mousewheel",function(){n.$apply(function(){localStorage.metaCampusLastAccessTime=(new Date).getTime()})}),document.addEventListener("mousemove",function(){n.$apply(function(){localStorage.metaCampusLastAccessTime=(new Date).getTime()})}),s.startLogoutTimer=function(e){n.logoutTimerInterval=setInterval(function(){(new Date).getTime()-Number(localStorage.metaCampusLastAccessTime)>=e?n.started===!1&&n.startNgIdlemodule():n.started===!0&&n.stopNgIdlemodule()},200)},s};return["$idle","$modal","$rootScope","$interval","$window",e]})}(define),function(e){"use strict";e("common/services/logout-timer-config",[],function(){var e=function(e){e.idleDuration(5),e.warningDuration(60)};return["$idleProvider",e]})}(define),function(e){"use strict";e("common/services/easypiechart",[],function(){var e="easypiechart";angular.module("easypiechart",[]).directive("easypiechart",[function(){return{restrict:"A",require:"?ngModel",scope:{percent:"=",options:"="},link:function(e,t,r){e.percent=e.percent||0;var i={barColor:"#ef1e25",trackColor:"#f9f9f9",scaleColor:"#dfe0e0",scaleLength:5,lineCap:"round",lineWidth:3,size:110,rotate:0,animate:{duration:1e3,enabled:!0}};e.options=angular.extend(i,e.options);var s=new n(t[0],i);e.$watch("percent",function(e,t){s.update(e)})}}}]);var t=function(e,t){var n,r=document.createElement("canvas");e.appendChild(r),typeof G_vmlCanvasManager!="undefined"&&G_vmlCanvasManager.initElement(r);var i=r.getContext("2d");r.width=r.height=t.size;var s=1;window.devicePixelRatio>1&&(s=window.devicePixelRatio,r.style.width=r.style.height=[t.size,"px"].join(""),r.width=r.height=t.size*s,i.scale(s,s)),i.translate(t.size/2,t.size/2),i.rotate((-0.5+t.rotate/180)*Math.PI);var o=(t.size-t.lineWidth)/2;t.scaleColor&&t.scaleLength&&(o-=t.scaleLength+2),Date.now=Date.now||function(){return+(new Date)};var u=function(e,t,n){n=Math.min(Math.max(-1,n||0),1);var r=n<=0?!0:!1;i.beginPath(),i.arc(0,0,o,0,Math.PI*2*n,r),i.strokeStyle=e,i.lineWidth=t,i.stroke()},a=function(){var e,n;i.lineWidth=1,i.fillStyle=t.scaleColor,i.save();for(var r=24;r>0;--r)r%6===0?(n=t.scaleLength,e=0):(n=t.scaleLength*.6,e=t.scaleLength-n),i.fillRect(-t.size/2+e,0,n,1),i.rotate(Math.PI/12);i.restore()},f=function(){return window.requestAnimationFrame||window.webkitRequestAnimationFrame||window.mozRequestAnimationFrame||function(e){window.setTimeout(e,1e3/60)}}(),l=function(){t.scaleColor&&a(),t.trackColor&&u(t.trackColor,t.lineWidth,1)};this.getCanvas=function(){return r},this.getCtx=function(){return i},this.clear=function(){i.clearRect(t.size/-2,t.size/-2,t.size,t.size)},this.draw=function(e){!t.scaleColor&&!t.trackColor?this.clear():i.getImageData&&i.putImageData?n?i.putImageData(n,0,0):(l(),n=i.getImageData(0,0,t.size*s,t.size*s)):(this.clear(),l()),i.lineCap=t.lineCap;var r;typeof t.barColor=="function"?r=t.barColor(e):r=t.barColor,u(r,t.lineWidth,e/100)}.bind(this),this.animate=function(e,n){var r=Date.now();t.onStart(e,n);var i=function(){var s=Math.min(Date.now()-r,t.animate.duration),o=t.easing(this,s,e,n-e,t.animate.duration);this.draw(o),t.onStep(e,n,o),s>=t.animate.duration?t.onStop(e,n):f(i)}.bind(this);f(i)}.bind(this)},n=function(e,n){var r={barColor:"#ef1e25",trackColor:"#f9f9f9",scaleColor:"#dfe0e0",scaleLength:5,lineCap:"round",lineWidth:3,size:110,rotate:0,animate:{duration:1e3,enabled:!0},easing:function(e,t,n,r,i){return t/=i/2,t<1?r/2*t*t+n:-r/2*(--t*(t-2)-1)+n},onStart:function(e,t){return},onStep:function(e,t,n){return},onStop:function(e,t){return}};if(typeof t!="undefined")r.renderer=t;else{if(typeof SVGRenderer=="undefined")throw new Error("Please load either the SVG- or the CanvasRenderer");r.renderer=SVGRenderer}var i={},s=0,o=function(){this.el=e,this.options=i;for(var t in r)r.hasOwnProperty(t)&&(i[t]=n&&typeof n[t]!="undefined"?n[t]:r[t],typeof i[t]=="function"&&(i[t]=i[t].bind(this)));typeof i.easing=="string"&&typeof jQuery!="undefined"&&jQuery.isFunction(jQuery.easing[i.easing])?i.easing=jQuery.easing[i.easing]:i.easing=r.easing,typeof i.animate=="number"&&(i.animate={duration:i.animate,enabled:!0}),typeof i.animate=="boolean"&&!i.animate&&(i.animate={duration:1e3,enabled:i.animate}),this.renderer=new i.renderer(e,i),this.renderer.draw(s),e.dataset&&e.dataset.percent?this.update(parseFloat(e.dataset.percent)):e.getAttribute&&e.getAttribute("data-percent")&&this.update(parseFloat(e.getAttribute("data-percent")))}.bind(this);this.update=function(e){return e=parseFloat(e),i.animate.enabled?this.renderer.animate(s,e):this.renderer.draw(e),s=e,this}.bind(this),this.disableAnimation=function(){return i.animate.enabled=!1,this},this.enableAnimation=function(){return i.animate.enabled=!0,this},o()};return e})}(define),function(e){"use strict";e("common/services/uiBreadcrumbs",[],function(){var e="angularUtils.directives.uiBreadcrumbs",t="directives/uiBreadcrumbs/uiBreadcrumbs.tpl.html",n;try{n=angular.module(e)}catch(r){n=angular.module(e,["ui.router"])}return n.directive("uiBreadcrumbs",function(e,t){return{restrict:"E",template:'<ul class="breadcrumb"><i class="ace-icon fa fa-home home-icon"></i><li ng-if="breadcrumbs[0].displayName != \'Dashboard\' && isDashboardShow != false">aman{{isDashboardShow}}<a href="/client/index-ace.html#/{{dashboardURL}}" >Dashboard</a></li><li ng-repeat="crumb in breadcrumbs" ng-class="{ active: $last }"><a ui-sref="{{ crumb.route }}" ng-if="!$last">{{crumb.displayName}}</a><span ng-show="$last">{{crumb.displayName }}</span></li></ul>',scope:{displaynameProperty:"@",abstractProxyProperty:"@?"},link:function(n){function r(){var e,r,o=[],a=t.$current;while(a&&a.name!=="")e=i(a),e&&(r=s(e),r!==!1&&!u(e,o)&&o.push({displayName:r,route:e.name})),a=a.parent;o.reverse(),n.breadcrumbs=o}function i(e){var r,i=e;return e.abstract===!0&&(typeof n.abstractProxyProperty!="undefined"?(r=o(n.abstractProxyProperty,e),r?i=t.get(r):i=!1):i=!1),i}function s(t){var r,i,s;return n.displaynameProperty?(i=o(n.displaynameProperty,t),i===!1?!1:typeof i=="undefined"?t.name:(r=typeof t.locals!="undefined"?t.locals.globals:t,s=e(i)(r),s)):t.name}function o(e,t){var n,r=e.split("."),i=t;for(n=0;n<r.length;n++){if(!angular.isDefined(i[r[n]]))return undefined;i=i[r[n]]}return i}function u(e,t){var n,r=!1;for(n=0;n<t.length;n++)t[n].route===e.name&&(r=!0);return r}n.breadcrumbs=[],t.$current.name!==""&&r(),n.$on("$stateChangeSuccess",function(){r()})}}}),e})}(define),function(e){"use strict";e("common/directives/listValues",[],function(){var e="directives.common";return angular.module(e,[]).directive("listValues",function(){return{restrict:"AE",scope:{setName:"=setName",metamodel:"=metamodel",form:"=",onvaluechange:"&",listdisable:"&",listrequired:"&",listinvalid:"&"},templateUrl:"app/common/directives/listValues.tpl.html",controller:function(e,t,n){e.getListOfValues=function(e){return t.get("/rest/value/"+e+"/valueList")}},link:function(e,t,n){e.getListOfValues(n.setname).then(function(t){e.dataValues=t.data;if(e.metamodel!==null&&e.metamodel!==undefined)for(var n=0;n<e.dataValues.length;n++)angular.equals(e.metamodel.id,e.dataValues[n].id)&&(e.metamodel=e.dataValues[n]);else e.metamodel=null},function(){e.dataValues="ERROR: failed to load data."})}}}),e})}(define),function(e){"use strict";e("common/common",["common/header/header-module","common/loading","common/directives/tree","common/directives/collapsetab","common/directives/slider","common/config-manager","common/run-manager","common/services/breadcrumbs","common/services/notifications","common/services/localizedMessages","common/services/i18nNotifications","common/services/rest-resource","common/services/logout-timer","common/services/logout-timer-config","common/services/easypiechart","common/services/uiBreadcrumbs","common/directives/listValues"],function(e,t,n,r,i,s,o,u,a,f,l,c,h,p,d,v,m){var g="services.breadcrumbs";angular.module(g,[]).factory("breadcrumbs",u);var y="services.notifications";angular.module(y,[]).factory("notifications",a);var b="services.localizedMessages";angular.module(b,[]).factory("localizedMessages",f);var w="services.i18nNotifications";angular.module(w,[y,b]).factory("i18nNotifications",l);var E="restResource";angular.module(E,[]).factory("restResource",c);var S="app.common",x=angular.module(S,["angular-underscore","pascalprecht.translate","ngGrid","ngRoute","ngResource","ui.router","ui.bootstrap","ui.select2","ngIdle","datePicker","ngSanitize","textAngular","angularFileUpload","ngDragDrop",g,e,t,n,r,i,w,E,d,v,m]);return x.run(o),x.config(s),x.factory("_",function(){return window._}),x.config(p).factory("logoutTimer",h),S})}(define),function(e){"use strict";e("home/home-route",[],function(){var e=function(e,t){t.state("Home",{url:"/home",templateUrl:"app/home/views/home-page.html",controller:"HomePageCtrl",data:{displayName:"Home"}})};return["$routeProvider","$stateProvider",e]})}(define),function(e){"use strict";e("home/controllers/home-page-ctrl",[],function(){var e=function(e,t,n,r,i,s){e.postData=function(){t.post("/eventManagment/dataFile/contacts.json",{params:{name:"kuldeep"}}).success(function(e){console.log(e)}).error(function(e){console.log(e)})}};return["$scope","$http","$location","$state","$rootScope","i18nNotifications",e]})}(define),function(e){"use strict";e("home/services/home-page-service",[],function(){var e=function(e,t){var n=e("/rest/HomePage/:operation",{operation:"@operation"},{getHomePageForGrid:{method:"GET",params:{operation:"data.do"}},getHomePageForEdit:{method:"GET",params:{operation:"beforeEdit"}},getHomePageForProfile:{method:"GET",params:{operation:"showDetail.do"}},deleteHomePage:{method:"DELETE",params:{operation:"delete"}},saveHomePage:{method:"POST",params:{operation:"save"}}});return n};return["$resource","$interpolate",e]})}(define),function(e){"use strict";e("home/home-module",["common/common","home/home-route","home/controllers/home-page-ctrl","home/services/home-page-service"],function(e,t,n,r){var i="homePage";return angular.module(i,[e,"ngGrid","restResource","services.i18nNotifications"]).config(t).controller("HomePageCtrl",n).factory("HomePageService",r),i})}(define),function(e){"use strict";e("contactUs/contactUs-route",[],function(){var e=function(e,t){t.state("Contact",{url:"/contact",templateUrl:"app/contactUs/views/contact-Us.html",controller:"ContactUsCtrl",data:{displayName:"Home"}})};return["$routeProvider","$stateProvider",e]})}(define),function(e){"use strict";e("contactUs/controllers/contact-Us-ctrl",[],function(){var e=function(e,t,n,r,i){function s(){var e={};return e.name="kuldepp",e.email="kuldeep.joshi@metacube.com",e.subject="hi",e.message="hi",e.receiverMails="kkuldeepjoshi5@gmail.com",e.to="kkuldeepjoshi5@gmail.com",e}t({method:"GET",url:"./dataFile/contacts.json"}).success(function(t){e.contacts=t.contacts}).error(function(e){i.removeAll()}),e.test=function(){t.get("/rest/event/getAll").success(function(e){alert(e)}).error(function(e){alert(e)})},e.sendMail=function(){var e=s();t.post("/rest/contactUs/sendMail").success(function(e){alert(e)}).error(function(e){alert(e)})}};return["$scope","$http","$location","ContactUsService","i18nNotifications",e]})}(define),function(e){"use strict";e("contactUs/services/contact-Us-service",[],function(){var e=function(e,t){var n=e("/eventManagment/rest/contactUs/:operation",{operation:"@operation"},{sendMail:{method:"POST",params:{operation:"sendMail"}}});return n};return["$resource","$interpolate",e]})}(define),function(e){"use strict";e("contactUs/contactUs-module",["common/common","contactUs/contactUs-route","contactUs/controllers/contact-Us-ctrl","contactUs/services/contact-Us-service"],function(e,t,n,r){var i="contactUs";return angular.module(i,[e,"ngGrid","restResource","services.i18nNotifications"]).config(t).controller("ContactUsCtrl",n).factory("ContactUsService",r),i})}(define),function(e){"use strict";e("about/about-route",[],function(){var e=function(e,t){t.state("About",{url:"/about",templateUrl:"app/about/views/about.html",controller:"AboutCtrl",data:{displayName:"About"}})};return["$routeProvider","$stateProvider",e]})}(define),function(e){"use strict";e("about/controllers/about-ctrl",[],function(){var e=function(e,t,n,r){e.getAll=function(){t.get("/eventManagment/rest/event/getAll").success(function(e){alert(e)}).error(function(e){alert(e)})},t({method:"GET",url:"/eventManagment/dataFile/about.json"}).success(function(t){e.abouts=t.abouts}).error(function(e){r.removeAll()})};return["$scope","$http","$location","i18nNotifications",e]})}(define),function(e){"use strict";e("about/services/about-service",[],function(){var e=function(e,t){var n=e("/rest/About/:operation",{operation:"@operation"},{getAboutForGrid:{method:"GET",params:{operation:"data.do"}},getAboutForEdit:{method:"GET",params:{operation:"beforeEdit"}},getAboutForProfile:{method:"GET",params:{operation:"showDetail.do"}},deleteAbout:{method:"DELETE",params:{operation:"delete"}},saveAbout:{method:"POST",params:{operation:"save"}}});return n};return["$resource","$interpolate",e]})}(define),function(e){"use strict";e("about/about-module",["common/common","about/about-route","about/controllers/about-ctrl","about/services/about-service"],function(e,t,n,r){var i="aboutPage";return angular.module(i,[e,"ngGrid","restResource","services.i18nNotifications"]).config(t).controller("AboutCtrl",n).factory("AboutService",r),i})}(define),function(e){"use strict";e("gallery/gallery-route",[],function(){var e=function(e,t){t.state("Gallery",{url:"/gallery",templateUrl:"app/gallery/views/gallery.html",controller:"GalleryCtrl",data:{displayName:"Gallery"}})};return["$routeProvider","$stateProvider",e]})}(define),function(e){"use strict";e("gallery/controllers/gallery-ctrl",[],function(){var e=function(e,t,n,r){e.images=[],e.sildeShow=function(){e.$parent.isGallery=!0},_.each(e.pics,function(t){e.images.push({src:t.imageUrl+".jpg",smallSrc:t.smallUrl+".jpg",name:t.name,title:t.description})})};return["$scope","$location","$http","i18nNotifications",e]})}(define),function(e){"use strict";e("gallery/services/gallery-service",[],function(){var e=function(e,t){var n=e("/rest/Gallery/:operation",{operation:"@operation"},{getGalleryData:{method:"GET",params:{operation:"data.do"}}});return n};return["$resource","$interpolate",e]})}(define),function(e){"use strict";e("gallery/gallery-module",["common/common","gallery/gallery-route","gallery/controllers/gallery-ctrl","gallery/services/gallery-service"],function(e,t,n,r){var i="galleryPage";return angular.module(i,[e,"ngGrid","restResource","services.i18nNotifications"]).config(t).controller("GalleryCtrl",n).factory("GalleryService",r),i})}(define),function(e){"use strict";e("ourServices/ourServices-route",[],function(){var e=function(e,t){t.state("OurService",{url:"/ourService",templateUrl:"app/ourServices/views/ourService.html",controller:"OurServiceCtrl",data:{displayName:"OurService"}})};return["$routeProvider","$stateProvider",e]})}(define),function(e){"use strict";e("ourServices/controllers/ourService-ctrl",[],function(){var e=function(e,t,n,r,i){};return["$scope","$location","$state","$rootScope","i18nNotifications",e]})}(define),function(e){"use strict";e("ourServices/services/ourService-service",[],function(){var e=function(e,t){var n=e("/rest/OurService/:operation",{operation:"@operation"},{getOurServiceForGrid:{method:"GET",params:{operation:"data.do"}},getOurServiceForEdit:{method:"GET",params:{operation:"beforeEdit"}},getOurServiceForProfile:{method:"GET",params:{operation:"showDetail.do"}},deleteOurService:{method:"DELETE",params:{operation:"delete"}},saveOurService:{method:"POST",params:{operation:"save"}}});return n};return["$resource","$interpolate",e]})}(define),function(e){"use strict";e("ourServices/ourServices-module",["common/common","ourServices/ourServices-route","ourServices/controllers/ourService-ctrl","ourServices/services/ourService-service"],function(e,t,n,r){var i="ourServicePage";return angular.module(i,[e,"ngGrid","restResource","services.i18nNotifications"]).config(t).controller("OurServiceCtrl",n).factory("OurServiceService",r),i})}(define),function(e){"use strict";e("profile/profile-route",[],function(){var e=function(e,t){t.state("profile",{url:"/profile",templateUrl:"app/profile/logIn/views/profile.html",controller:"ProfileCtrl",data:{displayName:"Profile"}})};return["$routeProvider","$stateProvider",e]})}(define),function(e){"use strict";e("profile/logIn/controllers/profile-ctrl",[],function(){var e=function(e,t,n,r,i){function s(){return"read"}e.login=function(){e.permission=s()},e.setView=function(e){t.path("/party")}};return["$scope","$location","$state","$rootScope","i18nNotifications",e]})}(define),function(e){"use strict";e("profile/logIn/services/profile-service",[],function(){var e=function(e,t){var n=e("/rest/LogIn/:operation",{operation:"@operation"},{getLogInForGrid:{method:"GET",params:{operation:"data.do"}},getLogInForEdit:{method:"GET",params:{operation:"beforeEdit"}},getLogInForProfile:{method:"GET",params:{operation:"showDetail.do"}},deleteLogIn:{method:"DELETE",params:{operation:"delete"}},saveLogIn:{method:"POST",params:{operation:"save"}}});return n};return["$resource","$interpolate",e]})}(define),function(e){"use strict";e("profile/party/party-route",[],function(){var e=function(e,t){t.state("party",{url:"/party",templateUrl:"app/profile/party/views/party-home.html",controller:"PartyHomeCtrl",data:{displayName:"party"}}).state("party.create",{url:"/create",templateUrl:"app/profile/party/views/party-create-edit.html",controller:"PartyCreateEditCtrl",data:{displayName:"create"}})};return["$routeProvider","$stateProvider",e]})}(define),function(e){"use strict";e("profile/party/controllers/party-home-ctrl",[],function(){var e=function(e,t,n,r,i,s){e.postData=function(){function o(){_.isEmpty(e.locationData)||e.locationData==null?(e.isGridDataEmpty=!0,e.isNotFound=!0):(e.isGridDataEmpty=!1,e.isNotFound=!1)}t.post("/eventManagment/dataFile/contacts.json",{params:{name:"kuldeep"}}).success(function(e){console.log(e)}).error(function(e){console.log(e)}),e.createPage=function(){n.path("/party/create")},e.pagingOptions={pageSizes:[40,50,70],pageSize:50,currentPage:1},e.setPagingData=function(t,n,r){var i=t.slice((r-1)*n,r*n);e.pagingData=i,e.pageGap=n*(r-1)+1,e.$$phase||e.$apply()},e.setPagingData(masterData,e.pagingOptions.pageSize,e.pagingOptions.currentPage),e.$watch("pagingOptions",function(t,n){t.pageSize!==n.pageSize&&(e.pagingOptions.currentPage=1),(t!==n||t.currentPage!==n.currentPage)&&e.setPagingData(masterData,e.pagingOptions.pageSize,e.pagingOptions.currentPage)},!0),e.$watch("filterOptions",function(t,n){t!==n&&e.getPagedDataAsync(e.pagingOptions.pageSize,e.pagingOptions.currentPage,e.filterOptions.filterText)},!0);var r='<a  ng-click="editPage(row)" tooltip-placement="auto" tooltip="Edit" tooltip-append-to-body="true" style="margin-left:4px;"><i class="fa fa-pencil-square-o fa-lg text-info" style="margin-top:3px;"></i></a>',i='<a ng-click="setDeleteRow(row)"  tooltip-placement="auto" tooltip="Delete" tooltip-append-to-body="true" data-toggle="modal" data-target="#deleteModel" style="margin-left:8px;"><i class="fa fa-trash-o fa-lg text-danger"></i></a>';e.locationGridOptions={multiSelect:!1,data:"pagingData",enableColumnResize:!0,enablePaging:!0,showFooter:!0,totalServerItems:"totalServerItems",pagingOptions:e.pagingOptions,sortInfo:{fields:["locationName"],directions:["asc"]},columnDefs:[{field:"id",visible:!1},{field:"",displayName:"S. No.",cellTemplate:'<div align="center" class="ngCellText">{{row.rowIndex + pageGap}}</div>',sortable:!1,width:"6%"},{field:"locationName",displayName:"Name"},{field:"categoryValue",displayName:"Category"},{field:"locationDescription",displayName:"Description"},{field:"active",displayName:"Active",cellTemplate:'<div class="ngCellText"><div ng-show="row.entity.active">Y</div><div ng-hide="row.entity.active">N</div></div>'},{field:"",cellTemplate:'<div><div  style="margin:1.5% 0 0 1%;"> '+r+i+"</div></div>"}]},e.setDeleteRow=function(t){e.deleteRow=t.entity},e.editPage=function(e){var t=e.entity.id;n.path("/location/edit").search({id:t})},e.deleteLocation=function(){var t={id:e.deleteRow.id};LocationService.deleteLocation(t,function(t){s.removeAll(),s.pushForCurrentRoute("location.delete.success","success",{},{});var n=e.locationData.indexOf(e.deleteRow);e.locationData.splice(n,1),e.totalServerItems=e.totalServerItems-1,e.setPagingData(e.locationData,e.pagingOptions.pageSize,e.pagingOptions.currentPage)})},e.changeChoice=function(t){t=="active"?(e.onlyActive=!0,angular.forEach(e.locationData,function(t){t.active&&e.onlyActiveData.push(t)}),e.totalServerItems=e.onlyActiveData.length,e.pagingOptions.currentPage=1,masterData=e.onlyActiveData,e.setPagingData(e.onlyActiveData,e.pagingOptions.pageSize,e.pagingOptions.currentPage)):(e.onlyActiveData=[],e.onlyActive=!1,e.totalServerItems=e.locationData.length,e.pagingOptions.currentPage=1,masterData=e.locationData,e.setPagingData(e.locationData,e.pagingOptions.pageSize,e.pagingOptions.currentPage))}}};return["$scope","$http","$location","$state","$rootScope","i18nNotifications",e]})}(define),function(e){"use restrict";e("profile/party/controllers/party-create-edit-ctrl",[],function(){var e=function(e,t,n,r,i,s,o){function u(t){return t!==undefined?t.partyName==null||t.partyName.trim()==""?(s.removeAll(),s.pushForCurrentRoute("party.name.error","warning",{},{}),!1):e.extraData.category==null&&angular.isUndefined(e.extraData.category)?(s.removeAll(),s.pushForCurrentRoute("party.category.error","warning",{},{}),!1):!0:(s.removeAll(),s.pushForCurrentRoute("party.requiredField.error","warning",{},{}),!1)}function a(){var t=angular.copy(e.party);return e.extraData.category!=null&&angular.isDefined(e.extraData.category)&&(t.categoryId=e.extraData.category.id,t.categoryValue=e.extraData.category.text),t}i.valueList.sort(function(e,t){return e.text>t.text?1:e.text<t.text?-1:0}),e.extraData=i,e.party={};if(e.operation=="edit"){e.isEdit=!0,e.party=e.extraData.party,e.extraData.division={},e.party.partyType!=null&&$.each(e.extraData.partyTypes,function(){e.party.partyType==this.value&&(e.party.partyType=this)});if(e.party.divisionId!=null||e.party.divisionId!=undefined)e.extraData.division.id=e.party.divisionId,e.extraData.division.text=e.party.divisionName,e.getPartyGroup();e.extraData.syllabusId!=null&&!_.isEmpty(e.extraData.syllabusId)&&(e.extraData.blobFileName=e.extraData.syllabusName)}else e.isEdit=!1,e.party.active=!0;e.cancel=function(){r.path("/party")},e.saveParty=function(){if(!u(e.party))return!1;var t=a();console.log(t),o.saveParty(t,function(e){s.removeAll(),s.pushForCurrentRoute("party.save.success","success",{},{}),r.path("/party")},function(e){console.log(e)})}};return["$scope","$http","$upload","$party","partyCreateEditData","i18nNotifications","PartyService",e]})}(define),function(e){"use strict";e("profile/party/services/party-service",[],function(){var e=function(e,t){var n=e("/rest/Party/:operation",{operation:"@operation"},{getPartyForGrid:{method:"GET",params:{operation:"data.do"}},getPartyForEdit:{method:"GET",params:{operation:"beforeEdit"}},getPartyForProfile:{method:"GET",params:{operation:"showDetail.do"}},deleteParty:{method:"DELETE",params:{operation:"delete"}},saveParty:{method:"POST",params:{operation:"save"}}});return n};return["$resource","$interpolate",e]})}(define),function(e){"use strict";e("profile/party/party-module",["common/common","profile/party/party-route","profile/party/controllers/party-home-ctrl","profile/party/controllers/party-create-edit-ctrl","profile/party/services/party-service"],function(e,t,n,r,i){var s="party";return angular.module(s,[e,"ngGrid","restResource","services.i18nNotifications"]).config(t).controller("PartyHomeCtrl",n).controller("PartyCreateEditCtrl",r).factory("PartyService",i),s})}(define),function(e){"use strict";e("profile/profile-module",["common/common","profile/profile-route","profile/logIn/controllers/profile-ctrl","profile/logIn/services/profile-service","profile/party/party-module"],function(e,t,n,r,i){var s="profile";return angular.module(s,[e,"ngGrid","restResource","services.i18nNotifications",i]).config(t).controller("ProfileCtrl",n).factory("ProfileService",r),s})}(define),function(e){"use strict";e("event/event-route",[],function(){var e=function(e,t){t.state("Event",{url:"/event",templateUrl:"app/event/views/event.html",controller:"EventCtrl",data:{displayName:"Event"}})};return["$routeProvider","$stateProvider",e]})}(define),function(e){"use strict";e("event/controllers/event-ctrl",[],function(){var e=function(e,t,n,r,i){e.redirect=function(n){e.setBG(n),t.path(n)}};return["$scope","$location","$state","$rootScope","i18nNotifications",e]})}(define),function(e){"use strict";e("event/services/event-service",[],function(){var e=function(e,t){var n=e("/rest/Event/:operation",{operation:"@operation"},{getEventForGrid:{method:"GET",params:{operation:"data.do"}},getEventForEdit:{method:"GET",params:{operation:"beforeEdit"}},getEventForProfile:{method:"GET",params:{operation:"showDetail.do"}},deleteEvent:{method:"DELETE",params:{operation:"delete"}},saveEvent:{method:"POST",params:{operation:"save"}}});return n};return["$resource","$interpolate",e]})}(define),function(e){"use strict";e("event/event-module",["common/common","event/event-route","event/controllers/event-ctrl","event/services/event-service"],function(e,t,n,r){var i="event";return angular.module(i,[e,"ngGrid","restResource","services.i18nNotifications"]).config(t).controller("EventCtrl",n).factory("EventService",r),i})}(define),function(e,t){"use strict";e("app-module",["app-ctrl","home/home-module","contactUs/contactUs-module","about/about-module","gallery/gallery-module","ourServices/ourServices-module","profile/profile-module","event/event-module"],function(e,n,r,i,s,o,u,a){var f,l="app.eventManagment";return f=t.module(l,["ngRoute","chieffancypants.loadingBar","ngAnimate",n,r,i,s,o,u,,a]).controller("AppCtrl",e),t.bootstrap(document.getElementsByTagName("html")[0],[l]),f})}(define,angular);