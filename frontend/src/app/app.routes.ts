import { Routes } from '@angular/router';
import { AuthGuard } from './auth/guards/auth.guard';
import { RoleGuard } from './auth/guards/role.guard';
import { Role } from './auth/models/auth.model';

export const routes: Routes = [
  {
    path: 'auth',
    loadChildren: () => import('./auth/auth.module').then(m => m.AuthModule)
  },
  {
    path: '',
    redirectTo: 'dashboard',
    pathMatch: 'full'
  },
  {
    path: 'dashboard',
    loadComponent: () => import('./dashboard/dashboard.component').then(c => c.DashboardComponent),
    canActivate: [AuthGuard]
  },
  {
    path: 'trips',
    loadChildren: () => import('./trips/trips.routes').then(m => m.TRIPS_ROUTES),
    canActivate: [RoleGuard],
    data: { roles: [Role.USER] }
  },
  {
    path: 'approvals',
    loadChildren: () => import('./approvals/approvals.routes').then(m => m.APPROVALS_ROUTES),
    canActivate: [RoleGuard],
    data: { roles: [Role.APPROVER] }
  },
  {
    path: 'finance',
    loadChildren: () => import('./finance/finance.routes').then(m => m.FINANCE_ROUTES),
    canActivate: [RoleGuard],
    data: { roles: [Role.FINANCE] }
  },
  {
    path: 'unauthorized',
    loadComponent: () => import('./shared/unauthorized/unauthorized.component').then(c => c.UnauthorizedComponent)
  },
  {
    path: '**',
    redirectTo: 'auth/login'
  }
];
