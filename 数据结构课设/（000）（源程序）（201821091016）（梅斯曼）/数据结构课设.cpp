#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#define N 10                //最多好友人数

typedef struct Friend{
	int id; 		 //管理系统中的id
    char name[10];   //姓名
    char sex[5];     //性别
    int year;       //出生年 
	int month;		//出生月 
	int day;		//出生日 
};
//链表数据结构
typedef struct LNode{
    Friend fri;   //当前节点中的Friend结构体
    LNode *next;     //next指向下一个LNode
}LNode,*LinkList;
LinkList FriendSystem;

//显示好友生日管理系统功能
int showFunctions(){
    printf("*************欢迎来到好友生日管理系统*************\n");
    printf("1、新增信息\t2、查看信息\t3、修改信息\n4、删除信息\t5、通过列表查看好友生日\n6、退出系统\n");
    printf("**************************************************\n");
	printf("\n请选择相关功能操作：");
    int choice = -1;    //定义用户的选择并初始化
    scanf("%d",&choice);
    return choice;
}

//将生日信息写入到birthday.txt文件中
void writeFile(LinkList &FriendSystem)     
{
	LNode *p = FriendSystem->next;
    LNode *fri = (LinkList)malloc(sizeof(LNode));
    FILE *fp;
    //打开文件 
    if ((fp=fopen("E:/360MoveData/Users/lenovo/Desktop/keshe/birthday.txt","wb"))==NULL)
    {
        printf("提示:不能创建birthday.txt文件\n");
        return;
    }
        
    LinkList head=NULL;
	head=FriendSystem->next;
	while(head){//顺序读入fri 
		fwrite(&head->fri,1,sizeof(LNode),fp);
		head = head->next;
	}    
	
    fclose(fp);//关闭文件 
    printf("提示:文件birthday.txt写入完成！\n");
}

//将birthday.txt文件中的学生记录读入到FriendSystem中
void readFile(LinkList &FriendSystem)     
{
	FriendSystem = (LinkList)malloc(sizeof(LNode));//初始化 
    FriendSystem->next = 0;
    Friend fri;
    FILE *fp;
	//打开文件 
    if ((fp=fopen("E:/360MoveData/Users/lenovo/Desktop/keshe/birthday.txt","rb"))==NULL)
    {
        printf("提示:不能打开birthday.txt文件\n");
        return;
    }
    LinkList tail=FriendSystem;
    while (fread(&fri,sizeof(LNode),1,fp)==1){//每次读出一个fri通过尾插法创建链表
    	LNode *node = (LinkList)malloc(sizeof(LNode));  //生成新节点
		node->fri=fri;
		tail->next=node;
		tail=node;
		tail->next=NULL;
	}
    fclose(fp);//关闭文件 
    printf("提示:文件birthday.txt读取完毕\n");
}

//新增信息
void addFriend(LinkList &FriendSystem){
	LNode *p = FriendSystem->next;
    LNode *fri = (LinkList)malloc(sizeof(LNode));//分配空间 
    int index = 0;
    while(p->next){//index为fri数量-1 
        index++;
        p = p->next;
    }
    printf("添加格式：姓名 性别 生日(yyyy-mm-dd)\n请输入：");
    Friend newFriend;//新建一个friend用来存放添加的数据 
    char str3[4],str4[2],str5[2]; 
    while(scanf("%s %s %4s-%2s-%2s",&newFriend.name,&newFriend.sex,&str3,&str4,&str5)!=5){
    	printf("输入格式错误，请重新输入:");
		fflush(stdin); //清缓存 
	}
	newFriend.year=atoi(str3);//将输入的字符串转换成整数 
	newFriend.month=atoi(str4);
	newFriend.day=atoi(str5);
	
    newFriend.id = index;//将newFrined添加到链表尾部 
    fri->fri = newFriend;
    p->next = fri;
    fri->next = 0;
    printf("录入成功!\n");
    
    int i = 0;	//重新排序，改变id 
    LNode *node = FriendSystem->next;
    while(node){
        node->fri.id = ++i;
        node = node->next;
    }  
}

//修改信息 	
void updateFriend(LinkList &FriendSystem){
	int i=0;
	printf("请输入要修改的好友信息id：");
	scanf("%d",&i);	
	LNode *p = FriendSystem->next;
    LNode *fri = (LinkList)malloc(sizeof(LNode));//分配空间 
    int index=0;
    while(p&&(index<i-1)){//这里是为了找到id所在位置 
        p = p->next;
		index++;
    }
    printf("添加格式：姓名 性别 生日(yyyy-mm-dd)\n请输入：");
    Friend newFriend = p->fri;
    char str3[4],str4[2],str5[2]; 
    while(scanf("%s %s %4s-%2s-%2s",&newFriend.name,&newFriend.sex,&str3,&str4,&str5)!=5){
    	printf("输入格式错误，请重新输入:");
		fflush(stdin); //清缓存 
	}
	newFriend.year=atoi(str3);//将输入的字符串转换成整数 
	newFriend.month=atoi(str4);
	newFriend.day=atoi(str5);
	p->fri = newFriend;//将改好的数据替换 
    printf("修改成功!\n");
}

//删除信息
void deleteFriend(LinkList &FriendSystem){
	printf("请输入要删除的好友id：");
    int i=0;
    scanf("%d",&i);//好友id 
    LNode *p = FriendSystem->next;
    LNode *fri = FriendSystem;
    int index=0;
    while(p&&(index<i-2)){//这里是为了找到id所在位置 
        p=p->next;
        ++index;
    }
    if(!p||!(p->next)||i<=0){
    	printf("查无此书！\n");
	}else{//删除操作 
		LNode *q=p->next;
		p->next=q->next;
		delete q;
		printf("删除好友成功!\n","");
	}
		
    i = 0;	//重新排序，改变id
    LNode *node = FriendSystem->next;
    while(node){
        node->fri.id = ++i;
        node = node->next;
    }
}

//计算从xxx到2020年4月28日的天数 
int day_diff(int year_start, int month_start, int day_start)
{
	int y2,m2,d2;
	int y1,m1,d1;
	
	m1 = (month_start+9)%12;
	y1 = year_start-m1/10;
	d1 = 365*y1+y1/4-y1/100+y1/400+(m1*306+5)/10+(day_start-1);
 
	m2 = (4+9)%12;
	y2 = 2020-m2/10;
	d2 = 365*y2+y2/4-y2/100+y2/400+(m2*306+5)/10+(29-1);
	
	return (d2-d1);
}	

//计算生日倒计时 
int day_timeout(int year_start, int month_start, int day_start)
{
	int y2,m2,d2;
	int y1,m1,d1;
	
	m1 = (month_start+9)%12;
	y1 = 2021-m1/10;
	d1 = 365*y1+y1/4-y1/100+y1/400+(m1*306+5)/10+(day_start-1);
 
	m2 = (4+9)%12;
	y2 = 2020-m2/10;
	d2 = 365*y2+y2/4-y2/100+y2/400+(m2*306+5)/10+(29-1);
	
	return (d1-d2)%365;
}

//通过列表查看好友生日
void sortFriend(LinkList &FriendSystem){	
	LNode *p = FriendSystem->next;//求朋友个数 
	LNode *q = p;
	bool isCompared = false;
	int index = 0;
    while(p->next){
        index++;
        p = p->next;
    }
    int age[index];//存放好友年龄 
	int data[index];//存放好友出生天数
	int timeout[index];//存放好友生日倒计时 
	
	int i=0;
	while(q){
		Friend fri = q->fri;
        data[i]=day_diff(fri.year,fri.month,fri.day);//计算出生天数 
        timeout[i]=day_timeout(fri.year,fri.month,fri.day);//计算生日倒计时 
        q = q->next; 
        i++;
    }
    
	LNode *node = FriendSystem->next;     //循环体条件
	LNode *temp = FriendSystem->next;     //临时变量
	Friend com;   //比较
	LNode *temp_fri;   //临时变量
	int j=0,k=0,max=0;
	while(node->next){
	    com = node->fri;
	    temp_fri = node;
	    while(temp_fri){//按照生日倒计时排序 
	        if(timeout[j]>timeout[k]){
	            com = temp_fri->fri;
	            temp = temp_fri;
	            isCompared = true;
	            j++;
	        }
			k++;
	        temp_fri = temp_fri->next;
	    }
	    if(isCompared){
	        temp->fri = node->fri;
	        node->fri = com;
	        isCompared = false;
	    }
	    node = node->next;
	}
	printf("排序完毕!\n");
	
	int change[index];//用来转换倒计时的中间变量 
	i = 0;	//重新排序，改变id
    LNode *n = FriendSystem->next;
    while(n){
		age[i]=2020-(n->fri.year);
		change[i]=timeout[n->fri.id-1];//存储生日倒计时 
        n->fri.id = ++i;      
        n = n->next;
    }

	LNode *t = FriendSystem->next;
    if(t == 0){
        printf("当前好友生日管理系统内无好友!");
    }else{
        while(t){//打印好友生日信息 
            Friend fri = t->fri;
            printf("%-3d",fri.id);
            printf("%-5s",fri.name);
            printf("%-5s",fri.sex);
            printf("%04d-",fri.year);
            printf("%02d-",fri.month);
            printf("%02d",fri.day);
            printf(" 该好友今年 %d 岁了。",age[fri.id-1]);
            printf(" 该好友还有 %d 天过生日。\n",change[fri.id-1]);
            t = t->next;
        }
    }
}

//显示好友生日记录 
void display(LinkList &FriendSystem)   
{
	int j = 0;
	LNode *temp = FriendSystem->next;
    for(j;j<40;j++){
        printf("=");
    }
    printf("\n");
    if(temp == 0){
        printf("当前好友生日管理系统内无好友!");
    }else{
        while(temp){
            Friend fri = temp->fri;
            printf("%-3d",fri.id);
            printf("%-11s",fri.name);
            printf("%-14s",fri.sex);
            printf("%04d-",fri.year);
            printf("%02d-",fri.month);
            printf("%02d\n",fri.day);
            temp = temp->next;
        }
    }
    for(j=0;j<40;j++){
        printf("=");
    }
    printf("\n");
}

int main()
{
    printf("将birthday.txt文件中学生记录读入到FriendSystem中\n");
    readFile(FriendSystem);
    while(true){
        int choice = showFunctions();   //调用函数取得用户选择的功能
        if(choice == 1){	//新增信息 
            addFriend(FriendSystem);
            continue;
        }
        if(choice == 2){	//查看信息
            display(FriendSystem);
            continue;
        }
        if(choice==3){		//修改信息
            updateFriend(FriendSystem);
            continue;
        }
        if(choice==4){		//删除信息
            deleteFriend(FriendSystem);
            continue;
        }
        if(choice==5){		//通过列表查看好友生日
            sortFriend(FriendSystem);
            continue;
        }
        if(choice==6){		//退出系统 
        	printf("将生日信息写入birthday.txt文件\n");
    		writeFile(FriendSystem);
            printf("欢迎下次使用!\n");
            break;
        }
        if(choice>7||choice<1){
            printf("请输入正确选项!\n");
            continue;
        }
    }
    return 0;
}
