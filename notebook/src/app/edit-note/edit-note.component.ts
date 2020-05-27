import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Note } from '../components/notes-list/notes-list.component';
import { NotebookDataService } from '../services/notebook-data.service';

@Component({
  selector: 'app-edit-note',
  templateUrl: './edit-note.component.html',
  styleUrls: ['./edit-note.component.css']
})
export class EditNoteComponent implements OnInit {

  noteEdit: Note = new Note(-1,'', new Date());
  id: number;

  constructor(private _activatedRoute: ActivatedRoute,
              private _notebookDataService: NotebookDataService,
              private _router: Router) { }

  ngOnInit(): void {
    this.id = +this._activatedRoute.snapshot.params['id'];
    console.log("w komponencie edit " + this.id);
    if (this.id == -1) {
      this.emptyNoteBody()
    } else {
      this.getNote(this.id)
    }
    
  }

  getNote(id: number) {
    this._notebookDataService.getOneNote(this.id).subscribe(
      response => this.noteEdit = response
    )}

  saveNote(){
    if (this.id == -1) {
      this._notebookDataService.addNote(this.noteEdit).subscribe(
        response =>  {
          console.log("After add");
          this._router.navigate(['notes']);
        }
      )
    } else {
      this._notebookDataService.editNote(this.id, this.noteEdit).subscribe(
        response => {
          console.log('Po edycji ' + response);
          this._router.navigate(['notes'])
        }
      )
    }
  }

  backToHome() {
    this._router.navigate(['notes'])
  }

  emptyNoteBody() {
    this.noteEdit.content='';
    this.noteEdit.created = new Date();
  }
}
