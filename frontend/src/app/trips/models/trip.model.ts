export enum TripStatus {
  DRAFT = 'DRAFT',
  PENDING_APPROVAL = 'PENDING_APPROVAL',
  APPROVED = 'APPROVED',
  REJECTED = 'REJECTED'
}

export enum RefundStatusType {
  PENDING = 'PENDING',
  IN_PROCESS = 'IN_PROCESS',
  REFUNDED = 'REFUNDED'
}

export enum ExpenseType {
  CAR_RENTAL = 'CAR_RENTAL',
  HOTEL = 'HOTEL',
  FLIGHT = 'FLIGHT',
  TAXI = 'TAXI'
}

export interface Trip {
  id?: number;
  name: string;
  startDate: string;
  endDate: string;
  status: TripStatus;
  expenses: Expense[];
  approvalNotes?: ApprovalNote[];
  user?: {
    id: number;
    username: string;
    email: string;
    roles: string[];
  };
  totalExpenses?: number;
  refundStatus?: any;
  createdAt?: string;
  updatedAt?: string;
}

export interface Expense {
  id?: number;
  type: ExpenseType;
  totalPrice: number;
  createdAt?: string;
  details?: any;

  [key: string]: any;

  // Flight-specific fields
  airline?: string;
  departureLocation?: string;
  arrivalLocation?: string;
  departureTime?: string;
  arrivalTime?: string;

  // Car rental-specific fields
  carName?: string;
  pickupLocation?: string;
  dropLocation?: string;
  pickupTime?: string;
  dropTime?: string;

  // Hotel-specific fields
  hotelName?: string;
  location?: string;
  checkInDate?: string;
  checkOutDate?: string;

  // Taxi-specific fields
  from?: string;
  to?: string;
  dateTime?: string;
}

export interface ApprovalNote {
  id?: number;
  tripId: number;
  note: string;
  approverId: number;
  approverName?: string;
  createdAt?: string;
}

export interface RefundStatus {
  id?: number;
  tripId: number;
  status: RefundStatusType;
  financeUserId: number;
  financeUserName?: string;
  createdAt?: string;
  updatedAt?: string;
}

export interface CarRental {
  id?: number;
  expenseId?: number;
  carName: string;
  pickupDateTime: string;
  dropoffDateTime: string;
  pickupLocation: string;
  dropoffLocation: string;
}

export interface Hotel {
  id?: number;
  expenseId?: number;
  hotelName: string;
  location: string;
  checkInDate: string;
  checkOutDate: string;
}

export interface Flight {
  id?: number;
  expenseId?: number;
  airline: string;
  from: string;
  to: string;
  departureDateTime: string;
  arrivalDateTime: string;
}

export interface Taxi {
  id?: number;
  expenseId?: number;
  from: string;
  to: string;
  dateTime: string;
}
