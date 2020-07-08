#include<iostream>
#include<cmath>
using namespace std;

class Fraction{
	public:
		Fraction(int nu=0,int de=1):nume(nu),deno(de) {}
		void simplify();//化简 
		void display();//菜单 
		
		//输入输出运算符的重载
		friend istream &operator>>(istream &input,Fraction &x);
    	friend ostream &operator<<(ostream &output,Fraction x);
    	
    	//加减乘除运算符重载 
		Fraction operator+(const Fraction &f);  //两个分数相加
   		Fraction operator-(const Fraction &f);  //两个分数相减
   	 	Fraction operator*(const Fraction &f);  //两个分数相乘
    	Fraction operator/(const Fraction &f);  //两个分数相除

	private:
    int nume;  // 分子
    int deno;  // 分母
};

void Fraction::simplify()
{
	int nume1,deno1,r;
    deno1=fabs(deno);
    nume1=fabs(nume);
    while(r=nume1%deno1)  // 求m，n的最大公约数
    {
        nume1=deno1;
        deno1=r;
    }
    deno/=deno1;     // 化简
    nume/=deno1;
    if (deno<0)  // 将分母转化为正数
    {
        deno=-deno;
        nume=-nume;
    } 
}

// 重载输入运算符>>
istream &operator>>(istream &input,Fraction &x)
{   
    char ch;
    while(1)
    {
		input>>x.nume>>ch>>x.deno;
		if (x.deno==0)	//当分母为零时异常处理 
        {
			try
			{
				throw x.deno;
			}
			catch(int)
			{
        	    cout<<"分母为0, 请重新输入"<<endl;
			}
		}
		else
			break;
    }
    return input;
}

// 重载输出运算符<<
ostream &operator<<(ostream &output,Fraction x)
{
	if(x.nume%x.deno==0)	//如果分子是分母的整数倍，则化简成整数形式 
	{
		output<<x.nume/x.deno;
		return output;
	} 
    output<<x.nume<<'/'<<x.deno;
    return output;
}

// 分数相加
Fraction Fraction::operator+(const Fraction &f)
{
    Fraction t;
    t.nume=nume*f.deno+f.nume*deno;
    t.deno=deno*f.deno;
    t.simplify();
    return t;
}

// 分数相减
Fraction Fraction:: operator-(const Fraction &f)
{
    Fraction t;
    t.nume=nume*f.deno-f.nume*deno;
    t.deno=deno*f.deno;
    t.simplify();
    return t;
}

// 分数相乘
Fraction Fraction:: operator*(const Fraction &f)
{
    Fraction t;
    t.nume=nume*f.nume;
    t.deno=deno*f.deno;
    t.simplify();
    return t;
}

// 分数相除
Fraction Fraction:: operator/(const Fraction &f)
{
    Fraction t;
    t.nume=nume*f.deno;
    t.deno=deno*f.nume;
    t.simplify();
    return t;
}

void Fraction::display()
{
	cout<<"*****************************************\n";
	cout<<"**        欢迎使用分数计算器           **\n";
	cout<<"*****************************************\n";
	cout<<"**         使用加法请输入1             **\n";
	cout<<"**         使用减法请输入2             **\n";
	cout<<"**         使用乘法请输入3             **\n";
	cout<<"**         使用除法请输入4             **\n";
	cout<<"**           退出请输入0               **\n";
	cout<<"*****************************************\n";
}

int main()
{
	int a;
	Fraction x,y,z;
	x.display();
	for(;;)
	{
		cout<<"请选择功能："; 
		cin>>a;
		if(a==0)
		{
			cout<<"谢谢使用，再见！";
			return 0;
		}
		if(a==1||a==2||a==3||a==4)
		{
			cout<<"请输入两个分数（分数格式为a/b）"<<endl;
			cout<<"请输入第一个分数:"<<endl;
			cin>>x;
			cout<<"请输入第二个分数:"<<endl; 
			cin>>y;
			if(a==1)
			{
				z=x+y;
				cout<<"x+y="<<z<<endl;
			}
			else if(a==2)
			{
				z=x-y;
				cout<<"x-y="<<z<<endl;
			}
			else if(a==3)
			{
				z=x*y;
				cout<<"x*y="<<z<<endl;
			}
			else if(a==4)
			{
				z=x/y;
				cout<<"x/y="<<z<<endl;
			}	
			a=0;
		}
		else
		{
			cout<<"输入无效，请重新输入。"<<endl;
			a=0;
		} 	
	}
	return 0;	
}
