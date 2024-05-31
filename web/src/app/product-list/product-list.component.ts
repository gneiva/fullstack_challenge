import { AfterViewInit, Component, OnInit, ViewChild } from '@angular/core';
import { MatTableDataSource } from '@angular/material/table';
import { ProductService } from '../services/product.service';
import { AuthService } from '../services/auth.service';
import { Product } from '../models/product.model';
import { Page } from '../models/page.model';
import { MatPaginator } from '@angular/material/paginator';
import { MatSort } from '@angular/material/sort';

@Component({
  selector: 'app-product-list',
  templateUrl: './product-list.component.html',
  styleUrls: ['./product-list.component.css']
})

export class ProductListComponent implements OnInit, AfterViewInit {
  displayedColumns: string[] = ['name', 'description', 'price', 'categoryPath', 'stock', 'actions'];
  dataSource = new MatTableDataSource<Product>();
  totalElements = 0;

  @ViewChild(MatPaginator) paginator!: MatPaginator;
  @ViewChild(MatSort) sort!: MatSort;

  constructor(private productService: ProductService, private authService: AuthService) {}
  
  ngOnInit(): void { }

  ngAfterViewInit() {
    this.sort.sortChange.subscribe(() => {
      this.paginator.pageIndex = 0;
      this.paginator.pageSize = 5;
      this.loadProducts();
    });

    this.paginator.page.subscribe(() => this.loadProducts());

    this.loadProducts();
  }

  loadProducts() {
    const page = this.paginator.pageIndex;
    const size = this.paginator.pageSize;
    const sort = this.sort.active ? [`${this.sort.active},${this.sort.direction}`] : ['id,asc'];

    this.productService.getProducts(page, size, sort).subscribe((data: Page<Product>) => {
      console.log(data);
      this.dataSource.data = data.content;
      this.totalElements = data.totalElements;
    });
  }

  deleteProduct(id: string) {
    if (this.authService.isLoggedIn) {
      this.productService.deleteProduct(id).subscribe(() => {
        this.loadProducts();
      });
    }
  }

  get isLoggedIn() {
    return this.authService.isLoggedIn;
  }

  logout() {
    this.authService.logout();
  }

}

