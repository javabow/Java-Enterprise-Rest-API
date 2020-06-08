/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


(function() {

	var services = angular.module('je-transaction-paket-service', [ 'ngResource' ]);

	
	services.factory('PaketListFactory', [ '$resource', function($resource) {

		return $resource('service/transaksi/paket', {}, {
			query : {
				method : 'GET',
				isArray : false
			},
			create : {
				method : 'POST'
			}
		});

	} ]);
	
	services.factory('PaketEditFactory', [ '$resource', function($resource) {

		return $resource('service/transaksi/paket/:id', {}, {
			show : {
				method : 'GET',
				params: {id: '@id'}
			}
//			update : {
//				method : 'PUT',
//				params :{id: '@id'}
//			}
		});

	} ]);
	
})();