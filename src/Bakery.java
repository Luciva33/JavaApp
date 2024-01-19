import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Bakery {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		System.out.println("***パンを作って販売しよう***");
		ArrayList<Bread> breads = new ArrayList<Bread>();
		//ArrayList<Bakery> ingredients = new ArrayList<Bakery>();

		int ingredients = 0; //小麦の数
		int turn = 8; //一日の行動ターン数
		int earnings = 0; //一日の売り上げ

		for (; turn > 0; turn--) {

			System.out.print("1.材料を集める 2. パンを作る 3.  パンを販売する 4.  在庫 5.  終了>>");
			int select = new Scanner(System.in).nextInt();

			switch (select) {

			case 1: // 小麦を生成 

				int wheat = new Random().nextInt(3) + 1;

				ingredients += wheat;

				System.out.println("小麦を" + wheat + "個手した！");
				System.out.println("小麦の数 :" + ingredients + "個");
				System.out.println("残りターン:" + (turn - 1));
				break;

			case 2: // パンを生成

				String[] types = { "食パン", "カレーパン", "焼きそばパン" };

				int[] prices = { 50, 100, 200 }; //価格

				System.out.println("***何のパンを作りますか？***");
				System.out.printf("小麦の残り:[%s]個\n", ingredients);
				System.out.println("[0].食パン        小麦コスト: 1  価格 : 50円 ");
				System.out.println("[1].カレーパン    小麦コスト: 2  価格 : 100円 ");
				System.out.print("[2].焼きそばパン  小麦コスト: 3  価格 : 200円 >> ");

				int breadSelect = new java.util.Scanner(System.in).nextInt();

				switch (breadSelect) {

				case 0: //食パン

					if (ingredients > 0) {
						ingredients--;

						int price = prices[breadSelect];
						String type = types[breadSelect];
						Bread bread = new Bread(type, price);
						System.out.println("\n" + type + "を作った！");
						breads.add(bread);
						for (Bread b : breads) {
							System.out.printf("[%s]\n", b.type);
						}
						System.out.printf("小麦の残り:[%s]個\n", ingredients);
						System.out.println("残りターン:" + (turn - 1));
						break;

					} else {

						System.out.println("小麦が足りません！");
						turn++;
						break;
					}

				case 1: //カレーパン

					if (ingredients > 1) {
						ingredients -= 2;

						int price = prices[breadSelect];
						String type = types[breadSelect];
						Bread bread = new Bread(type, price);
						System.out.println("\n" + type + "を作った！");
						breads.add(bread);
						for (Bread b : breads) {
							System.out.printf("[%s]\n", b.type);
						}
						System.out.printf("小麦の残り:[%s]個\n", ingredients);
						System.out.println("残りターン:" + (turn - 1));
						break;

					} else {

						System.out.println("小麦が足りません！");
						turn++;
						break;
					}

				case 2: //焼きそばパン

					if (ingredients > 2) {
						ingredients -= 3;

						int price = prices[breadSelect];
						String type = types[breadSelect];
						Bread bread = new Bread(type, price);
						System.out.println("\n" + type + "を作った！");
						breads.add(bread);
						for (Bread b : breads) {
							System.out.printf("[%s]\n", b.type);
						}
						System.out.printf("小麦の残り:[%s]個\n", ingredients);
						System.out.println("残りターン:" + (turn - 1));
						break;

					} else {

						System.out.println("小麦が足りません！");
						turn++;
						break;
					}

				default:

					System.out.println("選択肢を選んでください!");
					turn++;
					break;

				}
				break;

			case 3: // パンを販売

				//（できそうなら）店頭に並べる

				//パンがない場合
				if (breads.isEmpty()) {
					System.out.println("パンがありません!");
					turn++;
					break;
				}

				//作ったパンの表示

				while (true) {

					for (int i = 0; i < breads.size(); i++) {
						System.out.printf("%d・・・[%s])\n", i, breads.get(i).type);
					}

					//生成したパンの並び替え

					//パンの販売
					System.out.print("どのパンを売りますか？>>");
					int sellselect = new Scanner(System.in).nextInt();

					if (0 <= sellselect && sellselect < breads.size()) { //  0以上、bread.size未満の数字がはいる

						System.out.printf("[%s]を販売した！\n", breads.get(sellselect).type);

						earnings += breads.get(sellselect).price; //売上加算
						breads.remove(sellselect); //選択したパンをリストから消去

						System.out.println("一日の売り上げ:" + earnings + "円");
						System.out.println("残りターン:" + (turn - 1));

						System.out.println("ほかのパンも売る？");
						System.out.print("1. はい 2. いいえ >>");
						int choice = new Scanner(System.in).nextInt();
						if (choice == 1) {
							continue;

						} else if (choice == 2) {

							break;

						} else {
							System.out.println("選択肢を選んでください!");
							
							break;

						}

					} else {
						System.out.println("パンがありません!");
						turn++;
						break;}
				}

			case 4: //データ表示

				for (Bread b : breads) {
					System.out.printf("[%s]\n", b.type);
				}

				turn++;
				System.out.printf("小麦の残り:[%s]個\n", ingredients);
				System.out.println("残りターン:" + (turn - 1));
				System.out.println("一日の売り上げ:" + earnings + "円");
				break;

			case 5: //終了表示

				System.out.println("今日の営業時間を終了します");
				System.out.println("一日の売り上げ:" + earnings + "円");
				if (earnings != 0) {
					System.out.println("今日も一日お疲れ様！");
				} else {
					System.out.println("明日は頑張ろう！");
				}
				return;

			default:

				System.out.println("選択肢を選んでください!");
				turn++;
				break;
			}

		}

		//一日のターン終了

		System.out.println("今日の営業時間を終了します");
		System.out.println("一日の売り上げ:" + earnings + "円");

		if (earnings != 0) {
			System.out.println("今日も一日お疲れ様！");
		} else {
			System.out.println("明日は頑張ろう！");
		}

		//（できそうなら）一日パンがいくつ売れたか乱数で決める

	}

}