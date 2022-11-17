let host = "https://java6-da032-default-rtdb.firebaseio.com";
const app = angular.module("app", []);

app.controller("ctrl", function ($scope, $http) {
    $scope.form = {}
    $scope.items = {}

    $scope.reset = function () {
        $scope.form = { gender: true, country: 'VN' };
        $scope.key = null;
    }


    $scope.load_all = function () {
        var url = `${host}/students.json`;
        $http.get(url).then(resp => {
            $scope.items = resp.data;
            console.log("success", resp)
        }).catch(err => {
            console.log(err)
        });

    }
    $scope.edit = function (key) {
        var url = `${host}/students/${key}.json`;
        $http.get(url).then(resp => {
            $scope.form = resp.data;
            $scope.key = key;
            log("success", resp)
        }).catch(err => {
            log("error", err)
        });

    }

    $scope.update = function () {
        var items = angular.copy($scope.form);
        var url = `${host}/students/${$scope.key}.json`;
        $http.put(url, items).then(resp => {
            $scope.items[$scope.key] = resp.data;
            console.log("success", resp)
        }).catch(err => {
            console.log("error", err)
        });

    }

    $scope.delete = function (key) {
        var url = `${host}/students/${key}.json`;
        $http.delete(url).then(resp => {
            delete $scope.items[key];
            $scope.reset();
            console.log("success", resp)
        }).catch(err => {
            console.log("error", err)

        });
    }

    $scope.create = function () {
        var item = angular.copy($scope.form);
        var url = `${host}/students.json`;
        $http.post(url, item).then(resp => {
            $scope.key = resp.data.name;
            $scope.items[$scope.key] = item;
            $scope.reset();
            console.log("success", resp)
        });

    }
    //Thực hiện tải toàn bộ students
    $scope.load_all();
    $scope.reset();
});