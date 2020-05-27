import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { API_URL } from '../constants';
import { Note } from '../components/notes-list/notes-list.component';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class NotebookDataService {

  constructor(private _httpClient: HttpClient) { }

  //get all notes
  getAllNotes():Observable<Note[]> {
    const url:string = `${API_URL}`;
    return this._httpClient.get<Note[]>(url);
  }

  //one note get
  getOneNote(id: number):Observable<Note> {
    const url:string = `${API_URL}/${id}`;
    return this._httpClient.get<Note>(url);
  }

  //edit - PUT
  editNote(id:number, note:Note) {
    const url:string = `${API_URL}/${id}`;
    return this._httpClient.put(url, note);
  }

  //add - POST
  addNote(note:Note) {
    const url:string = `${API_URL}`;
    return this._httpClient.post(url, note);
  }

  //delete
  deleteNote(id: number) {
    const url:string = `${API_URL}/${id}`;
    return this._httpClient.delete(url);
  }

}
