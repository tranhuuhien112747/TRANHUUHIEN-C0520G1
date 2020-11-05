import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ProductService {
  public API_PRODUCT = ' http://localhost:3000/product';
  public API_CATEGORY = ' http://localhost:3000/category';

  constructor(
    public http: HttpClient
  ) {
  }

  getAllCategory(): Observable<any> {
    return this.http.get(this.API_CATEGORY);
  }

  getAllProduct(): Observable<any> {
    return this.http.get(this.API_PRODUCT);
  }

  getProductById(productId): Observable<any> {
    return this.http.get(this.API_PRODUCT + '/' + productId);
  }

  deleteProduct(productId): Observable<any> {
    return this.http.delete(this.API_PRODUCT + '/' + productId);
  }
}
