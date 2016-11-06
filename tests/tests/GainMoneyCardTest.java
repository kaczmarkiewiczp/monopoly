package tests;

import mocks.MockGUI;
import junit.framework.TestCase;
import monopoly.Card;
import monopoly.GameBoardCCGainMoney;
import monopoly.GameMaster;
import monopoly.MoneyCard;

public class GainMoneyCardTest extends TestCase {
    Card gainMoneyCard;
    GameMaster gameMaster;

    @Override
    protected void setUp() {
        gameMaster = new GameMaster();
        gameMaster.setGameBoard(new GameBoardCCGainMoney());
        gameMaster.setNumberOfPlayers(1);
	gameMaster.reset();
	gameMaster.setGUI(new MockGUI());
	gainMoneyCard = new MoneyCard("Get 50 dollars", 50, Card.TYPE_CC);
        gameMaster.getGameBoard().addCard(gainMoneyCard);
    }
    
    public void testGainMoneyCardAction() {
        int origMoney = gameMaster.getCurrentPlayer().getMoney();
	Card card = gameMaster.drawCCCard();
	assertEquals(gainMoneyCard, card);
	card.applyAction(gameMaster);
	assertEquals(origMoney + 50, gameMaster.getCurrentPlayer().getMoney());
    }
    
    public void testGainMoneyCardUI() {
        gameMaster.movePlayer(0, 1);
        assertTrue(gameMaster.getGUI().isDrawCardButtonEnabled());
        assertFalse(gameMaster.getGUI().isEndTurnButtonEnabled());
        gameMaster.btnDrawCardClicked();
        assertFalse(gameMaster.getGUI().isDrawCardButtonEnabled());
	assertTrue(gameMaster.getGUI().isEndTurnButtonEnabled());
    }
}
