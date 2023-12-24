import { Component, OnInit } from '@angular/core';
import { Produto } from '../produtos.produto'
import { ProdutoService } from '../produtos.service'
import { Router } from '@angular/router';
@Component({
  selector: 'app-produtos-list',
  templateUrl: './produtos-list.component.html',
  styleUrls: ['./produtos-list.component.css']
})
export class ProdutoListComponent implements OnInit {

  produtos!: Produto[];

  constructor(private produtoService: ProdutoService,
    private router: Router) { }

  ngOnInit(): void {
    this.getProdutos();
  }

  private getProdutos() {
    this.produtoService.getProdutosList().subscribe(data => {
      this.produtos = data;
    });
  }

  produtoDetails(id: number) {
    this.router.navigate(['produto-details', id]);
  }

  updateProduto(id: number) {
    this.router.navigate(['update-produto', id]);
  }

  deleteProduto(id: number) {
    this.produtoService.deleteProduto(id).subscribe(data => {
      console.log(data);
      this.getProdutos();
    })
  }
}
