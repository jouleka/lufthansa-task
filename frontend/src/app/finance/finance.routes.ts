import { Routes } from '@angular/router';

export const FINANCE_ROUTES: Routes = [
  {
    path: '',
    redirectTo: 'refunds',
    pathMatch: 'full'
  },
  {
    path: 'refunds',
    loadComponent: () => import('./refunds/refunds.component').then(c => c.RefundsComponent)
  },
  {
    path: 'reports',
    loadComponent: () => import('./reports/reports.component').then(c => c.ReportsComponent)
  },
  {
    path: ':id',
    loadComponent: () => import('./refund-detail/refund-detail.component').then(c => c.RefundDetailComponent)
  }
];
