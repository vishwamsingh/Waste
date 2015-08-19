var app = angular.module('wasteTypeApp', []);
app.controller('wasteTypeCtrl', [ '$scope', '$http',
		function($scope, $http, getWasteTypeList) {
			$http.get('GetWasteType.html').then(function(res) {
				$scope.types = res.data;
			});

			$scope.submitWasteType = function() {
				
				var isDuplicate = false;
			    $scope.types.forEach(function(element) {
			    	alert(JSON.stringify(element)+'='+JSON.stringify($scope.newTypeName));
			        if (element.typename === JSON.stringify($scope.newTypeName)) {
			            isDuplicate = true;
			            return false;
			        }
			    });
			    if (!isDuplicate) {
					$http.get('NewWaste.html', {
						params : {
							typename : $scope.newTypeName,
							photorequired : $scope.newTypePhotoRequired
						}
					}).then(function(response) {
						$scope.addresult = "Added";
						$http.get('GetWasteType.html').then(function(res) {
							$scope.types = res.data;
						});
					}, function() {
						$scope.addresult = "Add Failed";
					});
				}
			};
		} ]);
