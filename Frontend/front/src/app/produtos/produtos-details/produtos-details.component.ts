import { Component, OnInit } from '@angular/core';
import { Produto } from '../produtos.produto';
import { ActivatedRoute } from '@angular/router';
import { ProdutoService } from '../produtos.service';

@Component({
  selector: 'app-produtos-details',
  templateUrl: './produtos-details.component.html',
  styleUrls: ['./produtos-details.component.css']
})
export class ProdutoDetailsComponent implements OnInit {

  id!: number;
  produto!: Produto;
  constructor(private route: ActivatedRoute, private employeService: ProdutoService) { }

  ngOnInit(): void {
    this.id = this.route.snapshot.params['id'];

    this.produto = new Produto();
    this.employeService.getProdutoById(this.id).subscribe(data => {
      this.produto = data;
    });
  }
}
