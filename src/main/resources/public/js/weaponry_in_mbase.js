var app = angular.module("demo", []);

app.controller("WeaponryInMbaseCtrl", function($scope, $http){
    var id;

    $scope.weaponry = [];
    var time = performance.now();
    $http.get('/api/weaponryinmbase/showall').then(function(response){
        $scope.weaponry = response.data;
        time = performance.now() - time;
        window.alert("Виведення відбулося за " + time + " мс.");
        var bases = [];
        $http.get('/api/militarybase/showall').then(function(response){
            bases = response.data;
            var select = document.getElementById('militaryBase');
            var selectMbaseUpd = docu   ment.getElementById('updMilitaryBase');
            var queryBase = document.getElementById('selectBase');

            for (var i = 0; i < bases.length; i++) {
                var option = document.createElement("option");
                option.text = bases[i].name;
                option.value = bases[i].id;

                select.add(option);

                console.log(select);
            }

            for (var j = 0; j < bases.length; j++){
                var option2 = document.createElement("option");
                option2.text = bases[j].name;
                option2.value = bases[j].id;

                selectMbaseUpd.add(option2);

                console.log(selectMbaseUpd);
            }

            for (var k = 0; k < bases.length; k++){
                var option3 = document.createElement("option");
                option3.text = bases[k].name;
                option3.value = bases[k].id;

                queryBase.add(option3);

                console.log(queryBase);
            }

        });

        var weaponryToAdd = [];
        $http.get('/api/weaponry/showall').then(function(response){
            weaponryToAdd = response.data;
            var select = document.getElementById('weaponry');
            var selectweaponryUpd = document.getElementById('updWeaponry');

            for (var i = 0; i < weaponryToAdd.length; i++) {
                var option = document.createElement("option");
                option.text = weaponryToAdd[i].name;
                option.value = weaponryToAdd[i].id;

                select.add(option);

                console.log(select);
            }

            for (var j = 0; j < weaponryToAdd.length; j++) {
                var option2 = document.createElement("option");
                option2.text = weaponryToAdd[j].name;
                option2.value = weaponryToAdd[j].id;

                selectweaponryUpd.add(option2);

                console.log(selectweaponryUpd);
            }
        });

    });

    $http.get('/api/army/showall').then(function(response) {
        console.log(response);
        var armies = response.data;
        var selectArmyQuery = document.getElementById('selectArmy');

        for (var k = 0; k < armies.length; k++){
            var option3 = document.createElement("option");
            option3.text = armies[k].name;
            option3.value = armies[k].id;

            selectArmyQuery.add(option3);
            console.log(selectArmyQuery);
        }

    });

    $http.get('/api/division/showall').then(function(response) {
        console.log(response);
        var divisions = response.data;
        var selectDivisionQuery = document.getElementById('selectDivision');

        for (var k = 0; k < divisions.length; k++){
            var option3 = document.createElement("option");
            option3.text = divisions[k].name;
            option3.value = divisions[k].id;

            selectDivisionQuery.add(option3);
            console.log(selectDivisionQuery);
        }


    });

    $http.get('/api/corps/showall').then(function(response) {
        console.log(response);
        var corps = response.data;
        var selectCorpsQuery = document.getElementById('selectCorps');

        for (var k = 0; k < corps.length; k++){
            var option3 = document.createElement("option");
            option3.text = corps[k].name;
            option3.value = corps[k].id;

            selectCorpsQuery.add(option3);
            console.log(selectCorpsQuery);
        }

    });


    this.createWeaponryInMbase = function createweaponryInMbase(){
        var militaryBaseId = document.getElementById('militaryBase').value;
        var weaponryId = document.getElementById('weaponry').value;
        var amount = document.getElementById('amount').value;

        var request = {
            method: 'PUT',
            url : '/api/weaponryinmbase/insert?mbaseId=' + militaryBaseId + '&weaponryId=' + weaponryId + '&amount=' + amount
        };

        var time = performance.now();
        $http(request).then(function(response){
            time = performance.now() - time;
            window.alert("Створення відбулося за " + time + " мс.");
            console.log(response);
            window.location.reload();
        });
    };

    this.startUpdate = function startUpdate(idToUpdate, militaryBaseId, weaponryId, amount){
        id = idToUpdate;
        document.getElementById('updMilitaryBase').value = militaryBaseId;
        document.getElementById('updWeaponry').value = weaponryId;
        document.getElementById('updAmount').value = amount;
    };

    this.update = function update(){
        var militaryBaseId = document.getElementById('updMilitaryBase').value;
        var weaponryId = document.getElementById('updWeaponry').value;
        var amount = document.getElementById('updAmount').value;

        var request = {
            method: 'POST',
            url: '/api/weaponryinmbase/update?id=' + id + '&mbaseId=' + militaryBaseId + '&weaponryId=' + weaponryId
                                                    + '&amount=' + amount
        };

        var time = performance.now();
        $http(request).then(function(response){
            time = performance.now() - time;
            window.alert("Оновлення відбулося за " + time + " мс.");
            console.log(response);
            window.location.reload();
        });
    };

    this.del = function del(weaponryInMbaseId){
        var time = performance.now();
        $http.post('/api/weaponryinmbase/delete?id=' + weaponryInMbaseId).then(function(response){
            time = performance.now() - time;
            window.alert("Видалення відбулося за " + time + " мс.");
            window.location.reload();
        });
    }

    /**
     * QUERIES
     */

    this.selectByType = function selectByType(){
        var type = $('#selectType').val();

        $http.get('/api/weaponryinmbase/findAllByWeaponryType?type=' + type).then(function(response){
            $scope.weaponry = response.data;
        });
    };

    this.selectByBaseAndType = function selectByBaseAndType(){
        var id = $('#selectBase').val();
        var type = $('#selectTypeBaseAndType').val();

        $http.get('/api/weaponryinmbase/findAllByBaseAndWeaponryType?id=' + id + '&type=' + type).then(function(response){
            $scope.weaponry = response.data;
        });
    };

    this.selectByArmyAndType = function selectByArmyAndType(){
        var id = $('#selectArmy').val();
        var type = $('#selectTypeArmyAndType').val();

        $http.get('/api/weaponryinmbase/findAllByArmyAndWeaponryType?id=' + id + '&type=' + type).then(function(response){
            $scope.weaponry = response.data;
        });
    };

    this.selectByDivisionAndType = function selectByDivisionAndType(){
        var id = $('#selectDivision').val();
        var type = $('#selectTypeDivisionAndType').val();

        $http.get('/api/weaponryinmbase/findAllByDivisionAndWeaponryType?id=' + id + '&type=' + type).then(function(response){
            $scope.weaponry = response.data;
        });
    };

    this.selectByCorpsAndType = function selectByCorpsAndType(){
        var id = $('#selectCorps').val();
        var type = $('#selectTypeCorpsAndType').val();

        $http.get('/api/weaponryinmbase/findAllByCorpsAndWeaponryType?id=' + id + '&type=' + type).then(function(response){
            $scope.weaponry = response.data;
        });
    };
});



