import { Routes } from '@angular/router';

export const TRIPS_ROUTES: Routes = [
  {
    path: '',
    redirectTo: 'list',
    pathMatch: 'full'
  },
  {
    path: 'list',
    loadComponent: () => import('./trip-list/trip-list.component').then(c => c.TripListComponent)
  },
  {
    path: 'new',
    loadComponent: () => import('./trip-form/trip-form.component').then(c => c.TripFormComponent)
  },
  {
    path: ':id',
    loadComponent: () => import('./trip-detail/trip-detail.component').then(c => c.TripDetailComponent)
  },
  {
    path: ':id/edit',
    loadComponent: () => import('./trip-form/trip-form.component').then(c => c.TripFormComponent)
  },
  {
    path: ':id/expenses/new',
    loadComponent: () => import('./expense-form/expense-form.component').then(c => c.ExpenseFormComponent)
  }
];
