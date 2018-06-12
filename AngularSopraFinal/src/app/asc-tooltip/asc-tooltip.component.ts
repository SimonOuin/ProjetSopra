import { Component, OnInit, Input, HostListener } from '@angular/core';

@Component({
  selector: 'app-asc-tooltip,[app-asc-tooltip]',
  templateUrl: './asc-tooltip.component.html',
  styleUrls: ['./asc-tooltip.component.css']
})
export class AscTooltipComponent implements OnInit {

  @Input('asc-tooltip-titre')
    titre:string
  isVisible: boolean=false;
  
  constructor() { }

  ngOnInit() {
  }

  @HostListener('mouseenter')
  onMouseEnter(){
    this.isVisible=true;
  }
  
  @HostListener('mouseleave')
  onMouseLeaver(){
    this.isVisible=false;
  }
}
