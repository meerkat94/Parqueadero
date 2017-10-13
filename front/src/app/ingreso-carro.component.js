"use strict";
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};
var core_1 = require("@angular/core");
var Vehiculo_1 = require("./Vehiculo");
var ingresocarrocomponent = (function () {
    function ingresocarrocomponent() {
        this.model = new Vehiculo_1.Vehiculo('', 0);
        this.onsubmit = new core_1.EventEmitter();
    }
    ingresocarrocomponent.prototype.submit = function () {
        this.onsubmit.emit(this.model);
        console.log(this.model);
        this.model = new Vehiculo_1.Vehiculo('', 0);
    };
    return ingresocarrocomponent;
}());
__decorate([
    core_1.Output(),
    __metadata("design:type", Object)
], ingresocarrocomponent.prototype, "onsubmit", void 0);
ingresocarrocomponent = __decorate([
    core_1.Component({
        selector: 'ingreso-carro',
        templateUrl: './index2.html'
    })
], ingresocarrocomponent);
exports.ingresocarrocomponent = ingresocarrocomponent;
//# sourceMappingURL=ingreso-carro.component.js.map