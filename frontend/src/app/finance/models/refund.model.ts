import { Trip, RefundStatusType } from '../../trips/models/trip.model';

export interface RefundNote {
  id?: number;
  tripId?: number;
  note: string;
  createdBy?: string;
  createdAt?: string;
}

export interface RefundRequest {
  trip: Trip;
  refundStatus: RefundStatus;
  notes?: RefundNote[];
}

export interface RefundStatus {
  id?: number;
  tripId?: number;
  status: RefundStatusType;
  financeUser?: {
    id: number;
    username: string;
    email: string;
    roles: string[];
  };
  updatedAt?: string;
}

export interface RefundUpdate {
  tripId: number;
  status: RefundStatusType;
  updatedAt: string;
  message: string;
}
