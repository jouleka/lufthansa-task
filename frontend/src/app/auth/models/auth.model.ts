export interface LoginRequest {
  username: string;
  password: string;
}

export interface JwtResponse {
  token: string;
  type: string;
  id: number;
  username: string;
  email: string;
  roles: string[];
}

export interface User {
  id: number;
  username: string;
  email: string;
  roles: string[];
}

export enum Role {
  USER = 'ROLE_USER',
  APPROVER = 'ROLE_APPROVER',
  FINANCE = 'ROLE_FINANCE'
}
