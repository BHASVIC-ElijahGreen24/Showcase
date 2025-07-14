#include <ctype.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <time.h>
#include <windows.h>

//variables are almost all lists as each one holds the data for the separate guests
//you can get the data from the booking ID by finding which position the ID inputted is at
//this can then be used to find all data of a person by putting the position in to the variable
char first_name[6][35];
char last_name[6][35];
char DOB[6][9];
int guests[6];
char board_type[6][3];
int days[6];
char newspaper[6][1];
//must be empty for checking where to store data
char bookingID[6][40] = {"empty", "empty", "empty", "empty", "empty", "empty"};
int adults[6];
int children[6];
int available_rooms[6]={1,1,1,1,1,1};
char IDnum[5];
int room_choice[6];
int room_prices[6]={100, 100, 85, 75, 75, 50};
char DOBday[3];
char DOBmonth[3];
char DOByear[3];

char table_names[3][10] = {"Ender", "Naboo", "Tatooine"};
int free_seats[6][3] = {{0, 7, 4}, {0, 9, 4}, {1, 7, 4}, {1, 9, 4}, {2, 7, 4}, {2, 9, 4}}; // {time, seats available}
int g; // guest index

float cost = 0, board_cost = 0, news_cost = 0;

int room_cost = 0;


int date_validation(const int days, const int months, const int years) {
	int daysinmonth[12]={31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	if(years % 4 == 0)
		daysinmonth[1]=29;

	if (months<13)
	{
		if( days <= daysinmonth[months-1] ) {return 1;}
		return 0;}
	return 0;}

int name_validation(char name[35]) {
	int flag=0;
	for(int i=0;i<strlen(name);i++) {
		if( !isalpha(name[i])&&name[i]!='-') flag=1;
	}
	if(flag==0) return 1;
	else return 0;
}
void clear_input_buffer() { // fflush replacement
	int c;
	do { c = fgetc(stdin); } while(c != 10); // get next char while not newline
}

int check_table_time(const char *table_name, int time_slot) { // check the table name / time actually valid & such
	// check table name
	for(int i = 0; i < sizeof(table_names)/sizeof(table_names[0]); i++) {
		if(!strcmp(table_name, table_names[i])) { // table exists !

			// check time slot
			for(int j = 0; j < sizeof(free_seats)/sizeof(free_seats[0]); j++) {
				if(free_seats[j][0] == i && free_seats[j][1] == time_slot) { // if table id & time slot matches the one they're trying to book
					if(free_seats[j][2] < guests[g]) { // not enough seats for number of guests
						printf("Unfortunately, there are not enough seats available at that table & time for the number of guests you entered; please re-enter your choice of table name and time slot:\n");
						return 0;
					}
					free_seats[j][2] -= guests[g]; // update number of seats available at the table & time booked
					return 1; // valid time & table for number of guests
				}
			}

			printf("That time slot doesn't exist for the table you chose! Please re-enter your choice of table name and time slot:\n");
			return 0;
		}
	}

	printf("That table doesn't exist! Please re-enter your choice of table name and time slot:\n");
	return 0;
}

int dinnertables() {
	char inp_booking_id[40];
	char table_name[10];
	int time_slot;
	int any_available = 0;

	g = -1;

	printf("Please enter your booking ID to book a dinner table:\n");
	while(g == -1) {
		scanf("%s", inp_booking_id);
		clear_input_buffer();
		for(int i = 0; i < sizeof(bookingID)/sizeof(bookingID[0]); i++) { // if booking id in list
			if(!strcmp(bookingID[i], inp_booking_id)) {
				g = i;
				break;
			}
		}
		if(g == -1) printf("Unfortunately, that booking ID does not appear to match in the database; please re-enter your booking ID:\n");
	}

	if(!strcmp(board_type[g], "BB")) { // can only eat if full board
		printf("You didn't book the Full Board or the Half Board and therefore cannot book a dinner table. Apologies\n");
		return 0;
	}

	printf("\nTable Name | Time Slot | Spaces Free\n-------------------------------------\n");
	for(int i = 0; i < sizeof(free_seats)/sizeof(free_seats[0]); i++) { // fancy table
		if(free_seats[i][2] >= guests[g]) {
			printf("%-10s | %ipm       | %i\n", table_names[free_seats[i][0]], free_seats[i][1], free_seats[i][2]); // if enough seats free for party print in green
			any_available = 1;
		} else {
			printf("%-10s | %ipm       | %i\n", table_names[free_seats[i][0]], free_seats[i][1], free_seats[i][2]); // otherwise print in red
		}
	}

	if(!any_available) { // no tables with enough seats
		printf("\nApologies.. There are no more tables with enough seats for your guest count");
		return 0;
	}

	printf("\n\nEnter the table name and time slot at which you would like to eat: [separated by a space; ie Ender 7pm]\n");
	do {
		scanf("%s %i", table_name, &time_slot);
		table_name[0]=toupper(table_name[0]);
		clear_input_buffer();
	} while(!check_table_time(table_name, time_slot));

	printf("Thanks for booking the table %s for %ipm!\n", table_name, time_slot);

	return 0;
}

//subroutine for getting all data is made up of a while loop for each variable
int input_details(const int guest) {

	//all 6 inputs follow the same structure
	//first line asks the initial question
	//it starts a loop that will loop forever
	//removes any leftover inputs
	//takes the input with the numbers stopping illegal data
	//an if statement checks if data is valid and exits the loop if so
	//if it's not broken it asks you to do a valid input and loops

	printf("please enter your first name:\n");
	while (1) {
		fflush(stdin);
		scanf("%s", first_name[guest]);
		if (strlen(first_name[guest]) > 0 && strlen(first_name[guest]) <= 34 && name_validation(first_name[guest])) {
			break;
		}
		printf("\nInvalid input.\nPlease enter a valid name (1-34 characters):\n");}


	printf("please enter your last name:\n");
	while(1) {
		fflush(stdin);
		scanf("%s",last_name[guest]);
		if (strlen(last_name[guest]) > 0 && strlen(last_name[guest]) <= 34 && name_validation(last_name[guest])) {
			break;
		}
		printf("\nInvalid input.\nPlease enter a valid name length (1-34 characters):\n");}


	printf("please enter your date of birth (dd/mm/yy):\n");
	while(1){
		fflush(stdin);
		scanf("%s",DOB[guest]);
		sprintf(DOBday, "%c%c", DOB[guest][0], DOB[guest][1]);
		sprintf(DOBmonth, "%c%c", DOB[guest][3], DOB[guest][4]);
		sprintf(DOByear, "%c%c", DOB[guest][6], DOB[guest][7]);
		//makes sure all characters are the right type
		if (strlen(DOB[guest]) == 8 && isdigit(DOB[guest][0]) && isdigit(DOB[guest][1])
			&& DOB[guest][2] == '/' && isdigit(DOB[guest][3]) && isdigit(DOB[guest][4])
			&& DOB[guest][5] == '/' && isdigit(DOB[guest][6]) && isdigit(DOB[guest][7]) && date_validation(atoi(DOBday),atoi(DOBmonth),atoi(DOByear))){
			break;
			}
		printf("\nInvalid input.\nPlease enter a valid date in the format dd/mm/yy:\n");}

	while(1){
		//gets adults
		printf("how many adults are in your party:\n");
		fflush(stdin);
		scanf("%d",&adults[guest]);

		//gets children
		printf("how many children are in your party:\n");
		fflush(stdin);
		scanf("%d",&children[guest]);

		//finds total guests
		guests[guest]=adults[guest]+children[guest];
		if(guests[guest] >= 1 && guests[guest] <= 4 && adults[guest] > 0 && children[guest] >= 0)
			{break;}
		printf("\nInvalid input.\nplease enter 2 numbers above 0 that total between 1 and 4\n");}


	printf("Which type of board would you like (FB/HB/BB):\n");
	while(1){
		fflush(stdin);
		scanf("%s",board_type[guest]);
		if(strcmp(board_type[guest], "FB") == 0||strcmp(board_type[guest], "HB") == 0||strcmp(board_type[guest], "BB") == 0)
			{break;}
		printf("\nInvalid input.\nPlease enter a valid board type (FB, HB, or BB):\n");}

	printf("how many days are you staying for:\n");
	while(1){
		fflush(stdin);
		scanf("%d",&days[guest]);
		if (days[guest] >= 1 && days[guest] <= 28) break;
		printf("\nInvalid input.\nPlease enter a valid number of days (between 1 and 28):\n");}

	printf("would you like to receive the daily newspaper (Y/N):\n");
	while(1){
		fflush(stdin);
		scanf("%c",&newspaper[guest][0]);
		if(newspaper[guest][0]=='Y'||newspaper[guest][0]=='N')
		{break;}
		printf("\nInvalid input.\nplease enter a Y for yes or an N for no:\n");
	}
//sets IDnum to a random 5 digit number
	sprintf(IDnum, "%d", rand() % 90000 + 10000);
	//concatinates the last name and the IDnum
	sprintf(bookingID[guest], "%s%s", last_name[guest], IDnum);
printf("your booking ID is %s. please remember this\n",bookingID[guest]);
	printf("which room would you like to stay in\n");

	//only prints rooms that are available
for (int i=0;i<6;i++) {
	if (available_rooms[i]==1) {
		printf("room %d: %c%d \n",i+1,156,room_prices[i]);
	}
}
	//loop for available rooms
while(1) {
	//loop for valid rooms
	while(1){
		fflush(stdin);
		scanf("%d",&room_choice[guest]);
		if(room_choice[guest] <= 6 && room_choice > 0){break;}
		printf("\nInvalid input.\nplease enter a number from 1 to 6:\n");
	}
	if(available_rooms[room_choice[guest]-1] == 1) {
       available_rooms[room_choice[guest]-1]=0;
		break;
	}
	printf("\nsorry this room is taken please try another one\n");
}

    return 0;
}
int output_details(const int guest) {
	printf("guest %d first name:%s\n",guest+1,first_name[guest]);
	printf("guest %d last name:%s\n",guest+1,last_name[guest]);
	printf("guest %d DOB:%s\n",guest+1,DOB[guest]);
	printf("guest %d total people staying:%d\n",guest+1,guests[guest]);
	printf("guest %d board type:%s\n",guest+1,board_type[guest]);
	printf("guest %d is saying for %d days\n",guest+1,days[guest]);
	printf("guest %d wants paper?:%c\n",guest+1,newspaper[guest][0]);
	printf("guest %d is staying in room %d\n",guest+1,room_choice[guest]);
	return 0;
}

int checkout(void) {
	char inp_booking_ID[40];
	int guest = -1;
	int cost = 0;

	printf("Enter Booking ID");
	fflush(stdin);
	scanf("%s", inp_booking_ID);
	while (guest == -1) {
		for (int i = 0; i < 6; i++) {
			if (strcmp(bookingID[i], inp_booking_ID) == 0) {
				guest = i;
				break;
			}
		}
		if (guest == -1) {
			printf("Invalid Booking ID. Please try again.\n");
			scanf("%s", inp_booking_ID);
			fflush(stdin);
		}
	}
	room_cost=room_prices[room_choice[guest]-1]*days[guest];
	if (atoi(DOByear) > 24 && atoi(DOByear) < 60) room_cost = room_cost - (room_cost * 0.1); // if they are over 65, 10% discount
	cost+=room_cost;

	if (strcmp(board_type[guest], "FB") == 0){
		board_cost = (adults[guest]*20 + children[guest]*10)*days[guest];
	}
	else if (strcmp(board_type[guest], "HB") == 0){
		board_cost = (adults[guest]*15 + children[guest]*7.5)*days[guest];
	}
	else{
		board_cost = (adults[guest]*5 + children[guest]*2.5)*days[guest];
	}
	cost += board_cost;

	if (newspaper[guest][0]=='Y'){
		news_cost = 5.5;
	}
	cost += news_cost;

	printf("Guest %d, Booking ID: %s, Name: %s %s\n", guest + 1, bookingID[guest], first_name[guest], last_name[guest]);
	printf("Your room cost is %d\n", room_cost);
	printf("Your board cost is %.2f\n", board_cost);
	if (newspaper[guest][0]=='Y') {
		printf("Your news cost is %.2f\n", news_cost);
	}
	printf("Your total cost is %.2f\n\n", cost);
	available_rooms[room_choice[guest]-1]=1;
	strcpy(bookingID[guest], "empty");

	return 0;
}

int main(void) {
	

		srand(time(NULL));
		int menu, flag;

		for(;;) {
			menu = 0;

			while(menu > 4 || menu < 1) {
				printf("Please choose an option: [1-3]\n1). Check in\n2). Book a dinner table\n3). Check out\n\n");
				scanf("%d", &menu);
			}

			if(menu == 1) {
				flag = 0;
				//sets all variables for next empty ID
				for(int i=0;i<6;i++) {
					if(!strcmp(bookingID[i], "empty")) {
						input_details(i);
						output_details(i);
						flag = 1;
						break;
					}
				}
				if(!flag) printf("Sorry. We're all booked out!\n"); continue;

			}

			if(menu == 2) dinnertables(); printf("");

			if(menu == 3) checkout();

		}

	}


