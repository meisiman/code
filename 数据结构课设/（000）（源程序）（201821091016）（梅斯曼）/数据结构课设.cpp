#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#define N 10                //����������

typedef struct Friend{
	int id; 		 //����ϵͳ�е�id
    char name[10];   //����
    char sex[5];     //�Ա�
    int year;       //������ 
	int month;		//������ 
	int day;		//������ 
};
//�������ݽṹ
typedef struct LNode{
    Friend fri;   //��ǰ�ڵ��е�Friend�ṹ��
    LNode *next;     //nextָ����һ��LNode
}LNode,*LinkList;
LinkList FriendSystem;

//��ʾ�������չ���ϵͳ����
int showFunctions(){
    printf("*************��ӭ�����������չ���ϵͳ*************\n");
    printf("1��������Ϣ\t2���鿴��Ϣ\t3���޸���Ϣ\n4��ɾ����Ϣ\t5��ͨ���б�鿴��������\n6���˳�ϵͳ\n");
    printf("**************************************************\n");
	printf("\n��ѡ����ع��ܲ�����");
    int choice = -1;    //�����û���ѡ�񲢳�ʼ��
    scanf("%d",&choice);
    return choice;
}

//��������Ϣд�뵽birthday.txt�ļ���
void writeFile(LinkList &FriendSystem)     
{
	LNode *p = FriendSystem->next;
    LNode *fri = (LinkList)malloc(sizeof(LNode));
    FILE *fp;
    //���ļ� 
    if ((fp=fopen("E:/360MoveData/Users/lenovo/Desktop/keshe/birthday.txt","wb"))==NULL)
    {
        printf("��ʾ:���ܴ���birthday.txt�ļ�\n");
        return;
    }
        
    LinkList head=NULL;
	head=FriendSystem->next;
	while(head){//˳�����fri 
		fwrite(&head->fri,1,sizeof(LNode),fp);
		head = head->next;
	}    
	
    fclose(fp);//�ر��ļ� 
    printf("��ʾ:�ļ�birthday.txtд����ɣ�\n");
}

//��birthday.txt�ļ��е�ѧ����¼���뵽FriendSystem��
void readFile(LinkList &FriendSystem)     
{
	FriendSystem = (LinkList)malloc(sizeof(LNode));//��ʼ�� 
    FriendSystem->next = 0;
    Friend fri;
    FILE *fp;
	//���ļ� 
    if ((fp=fopen("E:/360MoveData/Users/lenovo/Desktop/keshe/birthday.txt","rb"))==NULL)
    {
        printf("��ʾ:���ܴ�birthday.txt�ļ�\n");
        return;
    }
    LinkList tail=FriendSystem;
    while (fread(&fri,sizeof(LNode),1,fp)==1){//ÿ�ζ���һ��friͨ��β�巨��������
    	LNode *node = (LinkList)malloc(sizeof(LNode));  //�����½ڵ�
		node->fri=fri;
		tail->next=node;
		tail=node;
		tail->next=NULL;
	}
    fclose(fp);//�ر��ļ� 
    printf("��ʾ:�ļ�birthday.txt��ȡ���\n");
}

//������Ϣ
void addFriend(LinkList &FriendSystem){
	LNode *p = FriendSystem->next;
    LNode *fri = (LinkList)malloc(sizeof(LNode));//����ռ� 
    int index = 0;
    while(p->next){//indexΪfri����-1 
        index++;
        p = p->next;
    }
    printf("��Ӹ�ʽ������ �Ա� ����(yyyy-mm-dd)\n�����룺");
    Friend newFriend;//�½�һ��friend���������ӵ����� 
    char str3[4],str4[2],str5[2]; 
    while(scanf("%s %s %4s-%2s-%2s",&newFriend.name,&newFriend.sex,&str3,&str4,&str5)!=5){
    	printf("�����ʽ��������������:");
		fflush(stdin); //�建�� 
	}
	newFriend.year=atoi(str3);//��������ַ���ת�������� 
	newFriend.month=atoi(str4);
	newFriend.day=atoi(str5);
	
    newFriend.id = index;//��newFrined��ӵ�����β�� 
    fri->fri = newFriend;
    p->next = fri;
    fri->next = 0;
    printf("¼��ɹ�!\n");
    
    int i = 0;	//�������򣬸ı�id 
    LNode *node = FriendSystem->next;
    while(node){
        node->fri.id = ++i;
        node = node->next;
    }  
}

//�޸���Ϣ 	
void updateFriend(LinkList &FriendSystem){
	int i=0;
	printf("������Ҫ�޸ĵĺ�����Ϣid��");
	scanf("%d",&i);	
	LNode *p = FriendSystem->next;
    LNode *fri = (LinkList)malloc(sizeof(LNode));//����ռ� 
    int index=0;
    while(p&&(index<i-1)){//������Ϊ���ҵ�id����λ�� 
        p = p->next;
		index++;
    }
    printf("��Ӹ�ʽ������ �Ա� ����(yyyy-mm-dd)\n�����룺");
    Friend newFriend = p->fri;
    char str3[4],str4[2],str5[2]; 
    while(scanf("%s %s %4s-%2s-%2s",&newFriend.name,&newFriend.sex,&str3,&str4,&str5)!=5){
    	printf("�����ʽ��������������:");
		fflush(stdin); //�建�� 
	}
	newFriend.year=atoi(str3);//��������ַ���ת�������� 
	newFriend.month=atoi(str4);
	newFriend.day=atoi(str5);
	p->fri = newFriend;//���ĺõ������滻 
    printf("�޸ĳɹ�!\n");
}

//ɾ����Ϣ
void deleteFriend(LinkList &FriendSystem){
	printf("������Ҫɾ���ĺ���id��");
    int i=0;
    scanf("%d",&i);//����id 
    LNode *p = FriendSystem->next;
    LNode *fri = FriendSystem;
    int index=0;
    while(p&&(index<i-2)){//������Ϊ���ҵ�id����λ�� 
        p=p->next;
        ++index;
    }
    if(!p||!(p->next)||i<=0){
    	printf("���޴��飡\n");
	}else{//ɾ������ 
		LNode *q=p->next;
		p->next=q->next;
		delete q;
		printf("ɾ�����ѳɹ�!\n","");
	}
		
    i = 0;	//�������򣬸ı�id
    LNode *node = FriendSystem->next;
    while(node){
        node->fri.id = ++i;
        node = node->next;
    }
}

//�����xxx��2020��4��28�յ����� 
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

//�������յ���ʱ 
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

//ͨ���б�鿴��������
void sortFriend(LinkList &FriendSystem){	
	LNode *p = FriendSystem->next;//�����Ѹ��� 
	LNode *q = p;
	bool isCompared = false;
	int index = 0;
    while(p->next){
        index++;
        p = p->next;
    }
    int age[index];//��ź������� 
	int data[index];//��ź��ѳ�������
	int timeout[index];//��ź������յ���ʱ 
	
	int i=0;
	while(q){
		Friend fri = q->fri;
        data[i]=day_diff(fri.year,fri.month,fri.day);//����������� 
        timeout[i]=day_timeout(fri.year,fri.month,fri.day);//�������յ���ʱ 
        q = q->next; 
        i++;
    }
    
	LNode *node = FriendSystem->next;     //ѭ��������
	LNode *temp = FriendSystem->next;     //��ʱ����
	Friend com;   //�Ƚ�
	LNode *temp_fri;   //��ʱ����
	int j=0,k=0,max=0;
	while(node->next){
	    com = node->fri;
	    temp_fri = node;
	    while(temp_fri){//�������յ���ʱ���� 
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
	printf("�������!\n");
	
	int change[index];//����ת������ʱ���м���� 
	i = 0;	//�������򣬸ı�id
    LNode *n = FriendSystem->next;
    while(n){
		age[i]=2020-(n->fri.year);
		change[i]=timeout[n->fri.id-1];//�洢���յ���ʱ 
        n->fri.id = ++i;      
        n = n->next;
    }

	LNode *t = FriendSystem->next;
    if(t == 0){
        printf("��ǰ�������չ���ϵͳ���޺���!");
    }else{
        while(t){//��ӡ����������Ϣ 
            Friend fri = t->fri;
            printf("%-3d",fri.id);
            printf("%-5s",fri.name);
            printf("%-5s",fri.sex);
            printf("%04d-",fri.year);
            printf("%02d-",fri.month);
            printf("%02d",fri.day);
            printf(" �ú��ѽ��� %d ���ˡ�",age[fri.id-1]);
            printf(" �ú��ѻ��� %d ������ա�\n",change[fri.id-1]);
            t = t->next;
        }
    }
}

//��ʾ�������ռ�¼ 
void display(LinkList &FriendSystem)   
{
	int j = 0;
	LNode *temp = FriendSystem->next;
    for(j;j<40;j++){
        printf("=");
    }
    printf("\n");
    if(temp == 0){
        printf("��ǰ�������չ���ϵͳ���޺���!");
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
    printf("��birthday.txt�ļ���ѧ����¼���뵽FriendSystem��\n");
    readFile(FriendSystem);
    while(true){
        int choice = showFunctions();   //���ú���ȡ���û�ѡ��Ĺ���
        if(choice == 1){	//������Ϣ 
            addFriend(FriendSystem);
            continue;
        }
        if(choice == 2){	//�鿴��Ϣ
            display(FriendSystem);
            continue;
        }
        if(choice==3){		//�޸���Ϣ
            updateFriend(FriendSystem);
            continue;
        }
        if(choice==4){		//ɾ����Ϣ
            deleteFriend(FriendSystem);
            continue;
        }
        if(choice==5){		//ͨ���б�鿴��������
            sortFriend(FriendSystem);
            continue;
        }
        if(choice==6){		//�˳�ϵͳ 
        	printf("��������Ϣд��birthday.txt�ļ�\n");
    		writeFile(FriendSystem);
            printf("��ӭ�´�ʹ��!\n");
            break;
        }
        if(choice>7||choice<1){
            printf("��������ȷѡ��!\n");
            continue;
        }
    }
    return 0;
}
