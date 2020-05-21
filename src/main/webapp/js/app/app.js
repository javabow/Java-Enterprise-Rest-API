(function(){
	
	var app = angular.module('je', ['ngRoute', 'datePicker', 'cgBusy', 'je-paging',
	                                 'je-main-workspace-controller',
                                         'je-master-pengirim-controller',
                                         'je-master-track-controller',
                                         'je-master-jenis-pengiriman-controller',
	                                 'angularUtils.directives.dirPagination']);

	app.config(function($routeProvider) {
		$routeProvider
		.when("/", {
			templateUrl : "template/main/home.html"
		})
                
                //Pengirim Routes
                .when("/master/pengirim", {
			templateUrl : "template/master/pengirim_list.html",
			controller: "PengirimListController"
		})
                .when("/master/pengirim/:nip/detail", {
			templateUrl : "template/master/pengirim_detail.html",
			controller: "PengirimDetailController"
		})
                .when("/master/pengirim/:nip/edit", {
			templateUrl : "template/master/pengirim_save.html",
			controller: "PengirimEditController"
		})
                .when("/master/pengirim/new", {
			templateUrl : "template/master/pengirim_save.html",
			controller: "PengirimCreateController"
		})
                // end of pengirim routes
                
                //Jenis Pengiriman routes
                .when("/master/jenis-pengiriman", {
			templateUrl : "template/master/jenis_pengiriman_list.html",
			controller: "JenisPengirimanListController"
		})
                .when("/master/jenis-pengiriman/:id/detail", {
			templateUrl : "template/master/jenis_pengiriman_detail.html",
			controller: "JenisPengirimanDetailController"
		})
                .when("/master/jenis-pengiriman/:id/edit", {
			templateUrl : "template/master/jenis_pengiriman_save.html",
			controller: "JenisPengirimanEditController"
		})
                .when("/master/jenis-pengiriman/new", {
			templateUrl : "template/master/jenis_pengiriman_save.html",
			controller: "JenisPengirimanCreateController"
		})
                //end of Jenis Pengiriman Routes
                
                //Track Paket routes
                .when("/master/track", {
			templateUrl : "template/master/track_list.html",
			controller: "TrackListController"
		})
                .when("/master/track/:id/detail", {
			templateUrl : "template/master/track_detail.html",
			controller: "TrackDetailController"
		})
                //end of Track Paket Routes
		;
	});
	
	app.filter('trusted', ['$sce', function ($sce) {
	    return function(url) {
	        return $sce.trustAsResourceUrl(url);
	    };
	}]);
	
})();



