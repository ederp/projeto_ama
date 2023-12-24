import { Component, OnInit } from '@angular/core';
import { ProdutoService } from '../produtos.service';
import { Produto } from '../produtos.produto';
import { ActivatedRoute, Router } from '@angular/router';
import { FormsModule } from '@angular/forms';

@Component({
  standalone: true,
  selector: 'app-update-produtos',
  templateUrl: './update-produtos.component.html',
  styleUrls: ['./update-produtos.component.css'],
  imports: [FormsModule]
})
export class UpdateProdutoComponent implements OnInit {

  id!: number;
  produto: Produto = new Produto();
  constructor(private produtoService: ProdutoService,
    private route: ActivatedRoute,
    private router: Router) { }

  ngOnInit(): void {
    this.id = this.route.snapshot.params['id'];

    this.produtoService.getProdutoById(this.id).subscribe(data => {
      this.produto = data;
    }, error => console.log(error));
  }

  onSubmit() {
    this.produtoService.updateProduto(this.id, this.produto).subscribe(data => {
      this.goToProdutoList();
    }
      , error => console.log(error));
  }

  goToProdutoList() {
    this.router.navigate(['/produtos']);
  }
}
