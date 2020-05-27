import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { RouterModule, Routes } from '@angular/router';
import { HttpClientModule } from '@angular/common/http'

import { AppComponent } from './app.component';
import { NotesListComponent } from './components/notes-list/notes-list.component';
import { EditNoteComponent } from './edit-note/edit-note.component';
import { WelcomeComponent } from './components/welcome/welcome.component';

const routes: Routes = [
  { path: '', component: WelcomeComponent },
  { path: 'home', component: WelcomeComponent },
  { path: 'notes', component: NotesListComponent },
  { path: 'edit/:id', component: EditNoteComponent }
]

@NgModule({
  declarations: [
    AppComponent,
    NotesListComponent,
    EditNoteComponent,
    WelcomeComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    RouterModule.forRoot(routes),
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
