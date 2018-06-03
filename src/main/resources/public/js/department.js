var app = angular.module("demo", []);

app.controller("DepartmentCtrl", function($scope, $http){
    var id;

    $scope.departments = [];
    var time = performance.now();
    $http.get('/api/department/showall').then(function(response){
        $scope.departments = response.data;
        time = performance.now() - time;
        window.alert("Виведення відбулося за " + time + " мс.");
        $http.get('/api/soldier/showall').then(function(response) {
            console.log(response);
            var captain = response.data;
            var select = document.getElementById('selectCaptain');
            var selectCaptainUpd = document.getElementById('updSelectCaptain');

            for (var i = 0; i < captain.length; i++) {
                var option = document.createElement("option");
                option.text = captain[i].name;
                option.value = captain[i].id;

                select.append(option);

                console.log(select);
            }

            for (var j = 0; j < captain.length; j++){
                var option2 = document.createElement("option");
                option2.text = captain[j].name;
                option2.value = captain[j].id;

                selectCaptainUpd.add(option2);
                console.log(selectCaptainUpd);
            }
        });
    });

    var platoons = [];
    $http.get('/api/platoon/showall').then(function(response) {
        console.log(response);
        var platoons = response.data;
        var select = document.getElementById('selectPlatoon');
        var selectPlatoonUpd = document.getElementById('updSelectPlatoon');

        for (var i = 0; i < platoons.length; i++) {
            var option = document.createElement("option");
            option.text = platoons[i].name;
            option.value = platoons[i].id;

            select.append(option);

            console.log(select);
        }

        for (var j = 0; j < platoons.length; j++){
            var option2 = document.createElement("option");
            option2.text = platoons[j].name;
            option2.value = platoons[j].id;

            selectPlatoonUpd.add(option2);
            console.log(selectPlatoonUpd);
        }


    });

    this.createDepartment = function createDepartment(){
        var codeNumber = document.getElementById('departmentCode').value;
        var name = document.getElementById('departmentName').value;
        var platoonId = document.getElementById('selectPlatoon').value;
        var captainId = document.getElementById('selectCaptain').value;

        var request = {
            method: 'PUT',
            url: '/api/department/insert?platoonId=' + platoonId + '&captainId=' + captainId,
            data : {
                name : name,
                codeNumber : codeNumber
            }
        };

        var time = performance.now();
        $http(request).then(function(response){
            time = performance.now() - time;
            window.alert("Створення відбулося за " + time + " мс.");
            console.log(response);
        });

        window.location.reload();
    };

    this.startUpdate = function startUpdate(idToUpdate, name, code, platoonId, captainId){
        id = idToUpdate;
        document.getElementById('updDepartmentName').value = name;
        document.getElementById('updDepartmentCode').value = code;
        document.getElementById('updSelectPlatoon').value = platoonId;
        document.getElementById('updSelectCaptain').value = captainId;

    };

    this.update = function update(){
        var name = document.getElementById('updDepartmentName').value;
        var codeNumber = document.getElementById('updDepartmentCode').value;
        var platoonId = document.getElementById('updSelectPlatoon').value;
        var captainId = document.getElementById('updSelectCaptain').value;

        var request = {
            method: 'POST',
            url: '/api/department/update?id=' + id + '&platoonId=' + platoonId + '&captainId=' + captainId,
            data : {
                name : name,
                codeNumber : codeNumber
            }
        };

        $http(request).then(function(response){
            console.log(response);
            window.location.reload();
        });
    };

    this.del = function del(id){
        $http.post('/api/department/delete?id=' + id).then(function(response){
            window.location.reload();
        });
    }
});



