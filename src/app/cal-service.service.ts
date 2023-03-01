import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Calculator } from './calculator';

@Injectable({
  providedIn: 'root'
})
export class CalServiceService {

  private baseURL : string=" ";
  private status: string= " ";
  constructor(private httpClient:HttpClient) {
    this.baseURL = 'http://localhost:8080/api';
  }

  public add(calculator: Calculator): Observable<any> {
    return this.httpClient.post('http://localhost:8080/api/add', calculator);
  }

  public sub(calculator: Calculator): Observable<any> {
    return this.httpClient.post('http://localhost:8080/api/sub', calculator);
  }

  public test(calculator: Calculator): Observable<any> {
    return this.httpClient.post('http://localhost:81/api/test', calculator);
  }

  public drop(calculator: Calculator): Observable<any> {
    return this.httpClient.post('http://localhost:81/api/drop', calculator);
  }

  public history(): Observable<Calculator[]> {
    return this.httpClient.get<Calculator[]>(this.baseURL + '/history');
  }
}
