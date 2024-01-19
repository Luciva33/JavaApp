
public class Bread {

	String type; // 種類
	int cost; //　生産コスト
	int price; //　価格

	public Bread(String type) {

		this.type = type;
	}

	public Bread(String type, int price) {

		this.type = type;
		this.price = price;
	}

	//  やりたいこと

	//　食パン　　　　　　コスト 小麦　１　価格　５０
	//　カレーパン　　　　コスト 小麦　２　価格　１００
	//　焼きそばパン　　　コスト 小麦　３　価格　２００

	//　一日の営業時間　ターン制
}
