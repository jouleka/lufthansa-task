import { Trip } from '../../trips/models/trip.model';

export interface ApprovalNote {
  id?: number;
  tripId?: number;
  note: string;
  approver?: {
    id: number;
    username: string;
    email: string;
    roles: string[];
  };
  createdAt?: string;
}

export interface ApprovalRequest {
  trip: Trip;
  notes: ApprovalNote[];
}
