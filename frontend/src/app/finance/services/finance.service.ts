import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Trip } from '../../trips/models/trip.model';
import { RefundRequest, RefundUpdate } from '../models/refund.model';

export interface ReportData {
  trips: Trip[];
  startDate: string;
  endDate: string;
}

const API_URL = 'http://localhost:8080/api';

@Injectable({
  providedIn: 'root'
})
export class FinanceService {
  constructor(private http: HttpClient) {}

  getApprovedTrips(): Observable<Trip[]> {
    return this.http.get<Trip[]>(`${API_URL}/finance/approved-trips`);
  }

  getTripWithRefundStatus(tripId: number): Observable<RefundRequest> {
    return this.http.get<RefundRequest>(`${API_URL}/finance/trips/${tripId}`);
  }

  getRefundHistory(): Observable<Trip[]> {
    return this.http.get<Trip[]>(`${API_URL}/finance/history`);
  }

  markAsInProcess(tripId: number, note?: string): Observable<RefundUpdate> {
    return this.http.post<RefundUpdate>(`${API_URL}/finance/trips/${tripId}/in-process`, { note });
  }

  markAsRefunded(tripId: number, note?: string): Observable<RefundUpdate> {
    return this.http.post<RefundUpdate>(`${API_URL}/finance/trips/${tripId}/refunded`, { note });
  }

  generateReport(startDate: string, endDate: string): Observable<ReportData> {
    return this.http.get<ReportData>(`${API_URL}/finance/reports?startDate=${startDate}&endDate=${endDate}`);
  }
}
