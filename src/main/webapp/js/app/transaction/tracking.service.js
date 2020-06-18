/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


(function() {

	var services = angular.module('je-transaction-tracking-service', [ 'ngResource' ]);

	
	services.factory('TrackingListFactory', [ '$resource', function($resource) {

		return $resource('service/transaksi/tracking', {}, {
			query : {
				method : 'GET',
				isArray : false
			},
			create : {
				method : 'POST'
			}
		});

	} ]);
	
	services.factory('TrackingEditFactory', [ '$resource', function($resource) {

		return $resource('service/transaksi/tracking/:id', {}, {
			show : {
				method : 'GET',
				params: {id: '@id'}
			},
			update : {
				method : 'PUT',
				params :{id: '@id'}
			}
		});

	} ]);
	
})();