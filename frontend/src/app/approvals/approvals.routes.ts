import { Routes } from '@angular/router';

export const APPROVALS_ROUTES: Routes = [
  {
    path: '',
    redirectTo: 'pending',
    pathMatch: 'full'
  },
  {
    path: 'pending',
    loadComponent: () => import('./pending-approvals/pending-approvals.component').then(c => c.PendingApprovalsComponent)
  },
  {
    path: ':id',
    loadComponent: () => import('./approval-detail/approval-detail.component').then(c => c.ApprovalDetailComponent)
  }
];
