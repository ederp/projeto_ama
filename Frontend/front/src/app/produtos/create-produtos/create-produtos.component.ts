import { Component, OnInit } from '@angular/core';
import { Produto } from '../produtos.produto';
import { ProdutoService } from '../produtos.service';
import { Router } from '@angular/router';
import { FormsModule } from '@angular/forms';

@Component({
  standalone: true,
  selector: 'app-create-produtos',
  templateUrl: './create-produtos.component.html',
  styleUrls: ['./create-produtos.component.css'],
  imports: [FormsModule]
})
export class CreateProdutoComponent implements OnInit {

  produto: Produto = new Produto();
  constructor(private produtoService: ProdutoService,
    private router: Router) { }

  ngOnInit(): void {
  }

  saveProduto() {
    this.produtoService.createProduto(this.produto).subscribe(data => {
      console.log(data);
      this.goToProdutoList();
    },
      error => console.log(error));
  }

  goToProdutoList() {
    this.router.navigate(['/produtos']);
  }

  onSubmit() {
    console.log(this.produto);
    this.saveProduto();
  }
}
