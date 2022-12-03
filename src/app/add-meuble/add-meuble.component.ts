import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { typeMeuble } from '../model/type.model';
import { meuble } from '../model/meuble.model';
import { MeubleService } from '../services/meuble.service';

@Component({
  selector: 'app-add-meuble',
  templateUrl: './add-meuble.component.html'
})
export class AddMeubleComponent implements OnInit {

  newMeuble = new meuble();
  typeMeubles! : typeMeuble[];
  newIdCat! : number;
  newtypeMeuble! : typeMeuble;
  
  constructor(private meubleService: MeubleService,
              private router : Router) { }

  ngOnInit(): void {

    this.meubleService.listetypeMeubles().
          subscribe(cats => {this.typeMeubles = cats._embedded.typeMeubles;
            console.log(cats);
        });
 
  }

 
  addMeuble(){
    this.newMeuble.typeMeuble = this.typeMeubles.find(cat => cat.idType == this.newIdCat)!;
    this.meubleService.ajouterMeuble(this.newMeuble)
                      .subscribe(prod => {
                      console.log(prod);
                      this.router.navigate(['meubles']);
                      }); 
    }




}
