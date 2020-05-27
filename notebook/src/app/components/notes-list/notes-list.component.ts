import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { NotebookDataService } from 'src/app/services/notebook-data.service';

@Component({
  selector: 'app-notes-list',
  templateUrl: './notes-list.component.html',
  styleUrls: ['./notes-list.component.css']
})
export class NotesListComponent implements OnInit {

  notes: Note[] = [];
  
  constructor(private _router: Router,
              private _notebookDataService: NotebookDataService) { }

  ngOnInit(): void {
    this.getNotesFromService();
  }

  editNote(id: number) {
    //console.log('Edit ' + id);
    this._router.navigate(['edit/' + id]);
  }

  deleteNote(id: number) {
    //console.log('Delete ' + id);
    this._notebookDataService.deleteNote(id).subscribe(
      response => { 
        this.getNotesFromService();
        console.log('Po usun ' + response);
      }
    )
  }

  getNotesFromService()  {
    this._notebookDataService.getAllNotes().subscribe(
      data => {
        console.log(data);
        this.notes = data;
      }
    )
  }

  addNote() {
    this._router.navigate(['edit/' + '-1']);
  }

}

export class Note {

  constructor(
    public id:number,
    public content:string,
    public created: Date) {
  }
  
}

// {
//   "id": 1,
//   "content": "Pierwsza notatka",
//   "created": "2020-05-27"
//   }