import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Trip } from '../../trips/models/trip.model';

const API_URL = 'http://localhost:8080/api';

@Injectable({
  providedIn: 'root'
})
export class ApprovalService {
  constructor(private http: HttpClient) {}

  getPendingApprovals(): Observable<Trip[]> {
    return this.http.get<Trip[]>(`${API_URL}/approver/trips/pending`);
  }

  getTripForApproval(tripId: number): Observable<Trip> {
    return this.http.get<Trip>(`${API_URL}/approver/trips/${tripId}`);
  }

  approveTrip(tripId: number, note?: string): Observable<Trip> {
    return this.http.post<Trip>(`${API_URL}/approver/trips/${tripId}/approve`, { note, approved: true });
  }

  rejectTrip(tripId: number, note?: string): Observable<Trip> {
    return this.http.post<Trip>(`${API_URL}/approver/trips/${tripId}/reject`, { note, approved: false });
  }
}
