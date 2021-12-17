import java.awt.*;

public abstract class Vehicle implements ITransport {
    /// <summary>
    /// ����� ���������� ��������� ����������
    /// </summary>
    protected float _startPosX;
    /// <summary>
    /// ������ ���������� ��������� ����������
    /// </summary>
    protected float _startPosY;
    /// <summary>
    /// ������ ���� ���������
    /// </summary>
    protected int _pictureWidth;
    /// <summary>
    /// ������ ���� ���������
    /// </summary>
    protected int _pictureHeight;
    /// <summary>
    /// ������������ ��������
    /// </summary>
    public int MaxSpeed; //{ protected set; get; }
    /// <summary>
    /// ��� ����������
    /// </summary>
    public float Weight; //{ protected set; get; }
    /// <summary>
    /// �������� ���� ������
    /// </summary>
    public Color MainColor; //{ protected set; get; }
    public void SetPosition(int x, int y, int width, int height)
    {
        _startPosX = x;
        _startPosY = y;
        _pictureWidth = width;
        _pictureHeight = height;
    }
    public abstract void DrawTransport(Graphics g);
    public abstract void MoveTransport(Direction direction);

}
