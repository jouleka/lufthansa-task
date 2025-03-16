import { Trip } from '../../trips/models/trip.model';

export interface ExpenseTypeSummary {
  count: number;
  amount: number;
}

export interface ReportSummary {
  totalTrips: number;
  totalExpenses: number;
  totalAmount: number;
  averagePerTrip: number;
  byExpenseType: Record<string, ExpenseTypeSummary>;
}

export interface ReportData {
  trips: Trip[];
  startDate: string;
  endDate: string;
}
