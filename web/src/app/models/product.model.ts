import { Category } from "./category.model";

export interface Product {
    id?: string;
    name: string;
    description: string;
    price: number;
    category: Category;
    quantity: number;
  }
  