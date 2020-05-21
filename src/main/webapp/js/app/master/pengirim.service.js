/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
(function() {

	var services = angular.module('je-master-pengirim-service', [ 'ngResource' ]);

	
	services.factory('PengirimListFactory', [ '$resource', function($resource) {

		return $resource('service/master/pengirim', {}, {
			query : {
				method : 'GET',
				isArray : false
			},
			create : {
				method : 'POST'
			}
		});

	} ]);
	
	services.factory('PengirimEditFactory', [ '$resource', function($resource) {

		return $resource('service/master/pengirim/:nip', {}, {
			show : {
				method : 'GET',
				params: {nip: '@nip'}
			},
			update : {
				method : 'PUT',
				params :{nip: '@nip'}
			},
			remove : {
				method : 'DELETE',
				params :{nip: '@nip'}
			}
		});

	} ]);
	
})();


