package tests;

import junit.framework.TestCase;
import monopoly.Card;
import monopoly.GameBoardCCLoseMoney;
import monopoly.GameMaster;
import monopoly.MockGUI;
import monopoly.MoneyCard;

public class LoseMoneyCardTest extends TestCase {
    GameMaster gameMaster;
    Card loseMoneyCard;

    @Override
    protected void setUp() {
        gameMaster = GameMaster.instance();
        gameMaster.setGameBoard(new GameBoardCCLoseMoney());
        gameMaster.setNumberOfPlayers(1);
        gameMaster.reset();
        gameMaster.setGUI(new MockGUI());
        loseMoneyCard = new MoneyCard("Pay 20 dollars", -20, Card.TYPE_CC);
        gameMaster.getGameBoard().addCard(loseMoneyCard);
    }
    
    public void testLoseMoneyCardAction() {
        int origMoney = gameMaster.getCurrentPlayer().getMoney();
        Card card = gameMaster.drawCCCard();
        assertEquals(loseMoneyCard, card);
        card.applyAction();
        assertEquals(origMoney - 20, gameMaster.getCurrentPlayer().getMoney());
    }
    
    public void testLoseMoneyCardUI() {
        gameMaster.movePlayer(0, 1);
        assertTrue(gameMaster.getGUI().isDrawCardButtonEnabled());
        assertFalse(gameMaster.getGUI().isEndTurnButtonEnabled());
        gameMaster.btnDrawCardClicked();
        assertFalse(gameMaster.getGUI().isDrawCardButtonEnabled());
        assertTrue(gameMaster.getGUI().isEndTurnButtonEnabled());
    }
}