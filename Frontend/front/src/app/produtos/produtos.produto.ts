export class Produto {
  id!: number;
  nome!: string;
  ativo!: boolean;
  sku!: string;
  categoria!: number;
  valorCusto!: number;
  icms!: number;
  valorVenda!: number;
  imagem!: string;
  dataCadastro = Date.now;
  quantidadeEstoque!: number;
}
