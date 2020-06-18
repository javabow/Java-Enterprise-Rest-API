(function(){
	
	var app = angular.module('je', ['ngRoute', 'datePicker', 'cgBusy', 'je-paging',
	                                 'je-main-workspace-controller',
                                         'je-master-pengirim-controller',
                                         'je-master-track-controller',
                                         'je-master-jenis-pengiriman-controller',
                                         'je-master-sender-controller',
                                         'je-master-receiver-controller',
                                         'je-transaction-paket-controller',
                                         'je-transaction-tracking-controller',
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
                 .when("/master/track/:id/edit", {
			templateUrl : "template/master/track_save.html",
			controller: "TrackEditController"
		})
                .when("/master/track/new", {
			templateUrl : "template/master/track_save.html",
			controller: "TrackCreateController"
		})
                //end of Track Paket Routes
                
                //Paket routes
                .when("/transaction/paket", {
			templateUrl : "template/transaction/paket_list.html",
			controller: "PaketListController"
		})
                .when("/transaction/paket/:id/detail", {
			templateUrl : "template/transaction/paket_detail.html",
			controller: "PaketDetailController"
		})
                .when("/transaction/paket/new", {
			templateUrl : "template/transaction/paket_save.html",
			controller: "PaketCreateController"
		})
                .when("/transaction/paket/:id/edit", {
			templateUrl : "template/transaction/paket_save.html",
			controller: "PaketEditController"
		})
                //end of Paket Routes
                
                //Sender Routes
                .when("/master/sender", {
			templateUrl : "template/master/sender_list.html",
			controller: "SenderListController"
		})
                .when("/master/sender/:id/detail", {
			templateUrl : "template/master/sender_detail.html",
			controller: "SenderDetailController"
		})
                .when("/master/sender/:id/edit", {
			templateUrl : "template/master/sender_save.html",
			controller: "SenderEditController"
		})
                .when("/master/sender/new", {
			templateUrl : "template/master/sender_save.html",
			controller: "SenderCreateController"
		})
                //end of Sender Routes
                
                //Receiver Routes
                .when("/master/receiver", {
			templateUrl : "template/master/receiver_list.html",
			controller: "ReceiverListController"
		})
                .when("/master/receiver/:id/detail", {
			templateUrl : "template/master/receiver_detail.html",
			controller: "ReceiverDetailController"
		})
                .when("/master/receiver/:id/edit", {
			templateUrl : "template/master/receiver_save.html",
			controller: "ReceiverEditController"
		})
                .when("/master/receiver/new", {
			templateUrl : "template/master/receiver_save.html",
			controller: "ReceiverCreateController"
		})
                //end of Receiver Routes
                
                //Tracking routes
                .when("/transaction/tracking", {
			templateUrl : "template/transaction/tracking_list.html",
			controller: "TrackingListController"
		})
                .when("/transaction/tracking/:id/detail", {
			templateUrl : "template/transaction/tracking_detail.html",
			controller: "TrackingDetailController"
		})
                .when("/transaction/tracking/new", {
			templateUrl : "template/transaction/tracking_save.html",
			controller: "TrackingCreateController"
		})
                .when("/transaction/tracking/:id/edit", {
			templateUrl : "template/transaction/tracking_save.html",
			controller: "TrackingEditController"
		})
                //end of Paket Routes
		;
                
	});
	
	app.filter('trusted', ['$sce', function ($sce) {
	    return function(url) {
	        return $sce.trustAsResourceUrl(url);
	    };
	}]);
	
})();



