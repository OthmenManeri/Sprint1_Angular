import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AddMeubleComponent } from './add-meuble/add-meuble.component';
import { ForbiddenComponent } from './forbidden/forbidden.component';
import { ListetypeMeublesComponent } from './liste-types/liste-types.component';
import { LoginComponent } from './login/login.component';
import { MeubleGuard } from './meuble.guard';
import { MeublesComponent } from './meubles/meubles.component';
import { RecherchePartypeMeubleComponent } from './recherche-par-type/recherche-par-type.component';
import { RechercheParNomComponent } from './recherche-par-nom/recherche-par-nom.component';
import { UpdateMeubleComponent } from './update-meuble/update-meuble.component';



const routes: Routes = [
  {path: "meubles", component : MeublesComponent},
  {path: "add-meuble", component : AddMeubleComponent, canActivate:[MeubleGuard]},
  {path: "updateMeuble/:id", component: UpdateMeubleComponent},
  {path: "recherchePartypeMeuble", component : RecherchePartypeMeubleComponent},
  {path: "rechercheParNom", component : RechercheParNomComponent},
  {path: "listetypeMeubles", component : ListetypeMeublesComponent},
  {path: 'login', component: LoginComponent},
  {path: 'app-forbidden', component: ForbiddenComponent},
  {path: "", redirectTo: "meubles", pathMatch: "full" }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
