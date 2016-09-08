package framework;

import javafx.scene.Node;

public class Screen
{
	private final String name;
	private final Node node;
	private final ScreenController controller;

	private Screen upper;
	private Screen right;
	private Screen lower;
	private Screen left;

	public Screen(String name, Node node, ScreenController controller)
	{
		this.name = name;
		this.node = node;
		this.controller = controller;
	}

	public String getName()
	{
		return this.name;
	}

	public Node getNode()
	{
		return this.node;
	}

	public ScreenController getController()
	{
		return this.controller;
	}

	public Screen getUpper()
	{
		return upper;
	}

	public void setUpper(Screen neighbor)
	{
		this.upper = neighbor;
		neighbor.lower = this;
	}

	public Screen getRight()
	{
		return right;
	}

	public void setRight(Screen neighbor)
	{
		this.right = neighbor;
		neighbor.left = this;
	}

	public Screen getLower()
	{
		return lower;
	}

	public void setLower(Screen neighbor)
	{
		this.lower = neighbor;
		neighbor.upper = this;
	}

	public Screen getLeft()
	{
		return left;
	}

	public void setLeft(Screen neighbor)
	{
		this.left = neighbor;
		neighbor.right = this;
	}
}
