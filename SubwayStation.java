package subwaystation;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Currency;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Locale;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Random;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.Stack;
import java.util.Timer;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.Vector;
import java.awt.Color;
import java.awt.Font;
import com.anylogic.engine.connectivity.ResultSet;
import com.anylogic.engine.connectivity.Statement;
import com.anylogic.engine.elements.*;
import com.anylogic.engine.markup.Network;
import com.anylogic.engine.Position;
import com.anylogic.engine.markup.PedFlowStatistics;
import com.anylogic.engine.markup.DensityMap;


import static java.lang.Math.*;
import static com.anylogic.engine.UtilitiesArray.*;
import static com.anylogic.engine.UtilitiesCollection.*;
import static com.anylogic.engine.presentation.UtilitiesColor.*;
import static com.anylogic.engine.HyperArray.*;

import com.anylogic.engine.*;
import com.anylogic.engine.analysis.*;
import com.anylogic.engine.connectivity.*;
import com.anylogic.engine.database.*;
import com.anylogic.engine.gis.*;
import com.anylogic.engine.markup.*;
import com.anylogic.engine.routing.*;
import com.anylogic.engine.presentation.*;
import com.anylogic.engine.gui.*;

import com.anylogic.libraries.modules.markup_descriptors.*;
import com.anylogic.libraries.pedestrian.*;

import java.awt.geom.Arc2D;

public class Main extends Agent
{
  // Parameters
  @AnyLogicInternalCodegenAPI
  private static Map<String, IElementDescriptor> elementDesciptors_xjal = createElementDescriptors( Main.class );
  
  @AnyLogicInternalCodegenAPI
  @Override
  public Map<String, IElementDescriptor> getElementDesciptors() {
    return elementDesciptors_xjal;
  }
  @AnyLogicCustomProposalPriority(type = AnyLogicCustomProposalPriority.Type.STATIC_ELEMENT)
  public static final Scale scale = new Scale( 10.0 );

  @Override
  public Scale getScale() {
    return scale;
  }



	

  /** Internal constant, shouldn't be accessed by user */
  @AnyLogicInternalCodegenAPI
  protected static final int _STATECHART_COUNT_xjal = 0;


  // Embedded Objects

  public com.anylogic.libraries.pedestrian.PedSource<
Agent 
> inflowSource;
  public com.anylogic.libraries.pedestrian.PedSink<
Agent 
> inflowSink;
  public com.anylogic.libraries.pedestrian.PedGoTo<
Agent 
> goToTrains;
  public com.anylogic.libraries.pedestrian.PedService<
Agent 
> pedService;
  public com.anylogic.libraries.pedestrian.PedService<
Agent 
> atTM;
  public com.anylogic.libraries.pedestrian.PedSelectOutput<
Agent 
> routePassengers;

  public String getNameOf( Agent ao ) {
    if ( ao == inflowSource ) return "inflowSource";
    if ( ao == inflowSink ) return "inflowSink";
    if ( ao == goToTrains ) return "goToTrains";
    if ( ao == pedService ) return "pedService";
    if ( ao == atTM ) return "atTM";
    if ( ao == routePassengers ) return "routePassengers";
    return super.getNameOf( ao );
  }

  public AgentAnimationSettings getAnimationSettingsOf( Agent ao ) {
    return super.getAnimationSettingsOf( ao );
  }


  public String getNameOf( AgentList<?> aolist ) {
    return super.getNameOf( aolist );
  }
  
  public AgentAnimationSettings getAnimationSettingsOf( AgentList<?> aolist ) {
    return super.getAnimationSettingsOf( aolist );
  }


  /**
   * Creates an embedded object instance<br>
   * <i>This method should not be called by user</i>
   */
  protected com.anylogic.libraries.pedestrian.PedSource<Agent> instantiate_inflowSource_xjal() {
    com.anylogic.libraries.pedestrian.PedSource<Agent> _result_xjal = new com.anylogic.libraries.pedestrian.PedSource<Agent>( getEngine(), this, null ) {
      @Override
      public TargetLine locationLine( Agent ped ) {
        return _inflowSource_locationLine_xjal( this, ped );
      }

      @AnyLogicInternalCodegenAPI
      public RateUnits getUnitsForCodeOf_rate() {
        return PER_HOUR;
      }
	};
    
    return _result_xjal;
  }

  /**
   * Setups parameters of an embedded object instance<br>
   * This method should not be called by user
   */
  private void setupParameters_inflowSource_xjal( final com.anylogic.libraries.pedestrian.PedSource<Agent> self, TableInput _t ) {
    self.locationType = self._locationType_DefaultValue_xjal();
    self.arrivalType = self._arrivalType_DefaultValue_xjal();
    self.rate = 
4000 
;
    self.rateSchedule = self._rateSchedule_DefaultValue_xjal();
    self.modifyRate = self._modifyRate_DefaultValue_xjal();
    self.arrivalSchedule = self._arrivalSchedule_DefaultValue_xjal();
    self.limitArrivals = self._limitArrivals_DefaultValue_xjal();
    self.maxArrivals = self._maxArrivals_DefaultValue_xjal();
    self.createGroups = self._createGroups_DefaultValue_xjal();
    self.groupFormation = self._groupFormation_DefaultValue_xjal();
    self.serviceGroupBehavior = self._serviceGroupBehavior_DefaultValue_xjal();
    self.solidCancelling = self._solidCancelling_DefaultValue_xjal();
    self.addToCustomPopulation = self._addToCustomPopulation_DefaultValue_xjal();
  }

  /**
   * Setups an embedded object instance<br>
   * This method should not be called by user
   */
  @AnyLogicInternalCodegenAPI
  private void doBeforeCreate_inflowSource_xjal( com.anylogic.libraries.pedestrian.PedSource<Agent> self, TableInput _t ) {
  }
  /**
   * Creates an embedded object instance<br>
   * <i>This method should not be called by user</i>
   */
  protected com.anylogic.libraries.pedestrian.PedSink<Agent> instantiate_inflowSink_xjal() {
    com.anylogic.libraries.pedestrian.PedSink<Agent> _result_xjal = new com.anylogic.libraries.pedestrian.PedSink<Agent>( getEngine(), this, null );
    
    return _result_xjal;
  }

  /**
   * Setups parameters of an embedded object instance<br>
   * This method should not be called by user
   */
  private void setupParameters_inflowSink_xjal( final com.anylogic.libraries.pedestrian.PedSink<Agent> self, TableInput _t ) {
  }

  /**
   * Setups an embedded object instance<br>
   * This method should not be called by user
   */
  @AnyLogicInternalCodegenAPI
  private void doBeforeCreate_inflowSink_xjal( com.anylogic.libraries.pedestrian.PedSink<Agent> self, TableInput _t ) {
  }
  /**
   * Creates an embedded object instance<br>
   * <i>This method should not be called by user</i>
   */
  protected com.anylogic.libraries.pedestrian.PedGoTo<Agent> instantiate_goToTrains_xjal() {
    com.anylogic.libraries.pedestrian.PedGoTo<Agent> _result_xjal = new com.anylogic.libraries.pedestrian.PedGoTo<Agent>( getEngine(), this, null ) {
      @Override
      public TargetLine locationLine( Agent ped ) {
        return _goToTrains_locationLine_xjal( this, ped );
      }
	};
    
    return _result_xjal;
  }

  /**
   * Setups parameters of an embedded object instance<br>
   * This method should not be called by user
   */
  private void setupParameters_goToTrains_xjal( final com.anylogic.libraries.pedestrian.PedGoTo<Agent> self, TableInput _t ) {
    self.mode = self._mode_DefaultValue_xjal();
    self.locationType = self._locationType_DefaultValue_xjal();
    self.reachTolerance = self._reachTolerance_DefaultValue_xjal();
  }

  /**
   * Setups an embedded object instance<br>
   * This method should not be called by user
   */
  @AnyLogicInternalCodegenAPI
  private void doBeforeCreate_goToTrains_xjal( com.anylogic.libraries.pedestrian.PedGoTo<Agent> self, TableInput _t ) {
  }
  /**
   * Creates an embedded object instance<br>
   * <i>This method should not be called by user</i>
   */
  protected com.anylogic.libraries.pedestrian.PedService<Agent> instantiate_pedService_xjal() {
    com.anylogic.libraries.pedestrian.PedService<Agent> _result_xjal = new com.anylogic.libraries.pedestrian.PedService<Agent>( getEngine(), this, null );
    
    return _result_xjal;
  }

  /**
   * Setups parameters of an embedded object instance<br>
   * This method should not be called by user
   */
  private void setupParameters_pedService_xjal( final com.anylogic.libraries.pedestrian.PedService<Agent> self, TableInput _t ) {
    self.services = 
fareGates 
;
    self.queueChoicePolicy = self._queueChoicePolicy_DefaultValue_xjal();
  }

  /**
   * Setups an embedded object instance<br>
   * This method should not be called by user
   */
  @AnyLogicInternalCodegenAPI
  private void doBeforeCreate_pedService_xjal( com.anylogic.libraries.pedestrian.PedService<Agent> self, TableInput _t ) {
  }
  /**
   * Creates an embedded object instance<br>
   * <i>This method should not be called by user</i>
   */
  protected com.anylogic.libraries.pedestrian.PedService<Agent> instantiate_atTM_xjal() {
    com.anylogic.libraries.pedestrian.PedService<Agent> _result_xjal = new com.anylogic.libraries.pedestrian.PedService<Agent>( getEngine(), this, null ) {
      @Override
      public double delayTime( ServiceUnit service, Agent ped ) {
        return _atTM_delayTime_xjal( this, service, ped );
      }

      @AnyLogicInternalCodegenAPI
      public TimeUnits getUnitsForCodeOf_delayTime() {
        return SECOND;
      }
	};
    
    return _result_xjal;
  }

  /**
   * Setups parameters of an embedded object instance<br>
   * This method should not be called by user
   */
  private void setupParameters_atTM_xjal( final com.anylogic.libraries.pedestrian.PedService<Agent> self, TableInput _t ) {
    self.services = 
ticketMachines 
;
    self.queueChoicePolicy = self._queueChoicePolicy_DefaultValue_xjal();
  }

  /**
   * Setups an embedded object instance<br>
   * This method should not be called by user
   */
  @AnyLogicInternalCodegenAPI
  private void doBeforeCreate_atTM_xjal( com.anylogic.libraries.pedestrian.PedService<Agent> self, TableInput _t ) {
  }
  /**
   * Creates an embedded object instance<br>
   * <i>This method should not be called by user</i>
   */
  protected com.anylogic.libraries.pedestrian.PedSelectOutput<Agent> instantiate_routePassengers_xjal() {
    com.anylogic.libraries.pedestrian.PedSelectOutput<Agent> _result_xjal = new com.anylogic.libraries.pedestrian.PedSelectOutput<Agent>( getEngine(), this, null ) {
      @Override
      public double probability1( Agent ped ) {
        return _routePassengers_probability1_xjal( this, ped );
      }
      @Override
      public double probability3( Agent ped ) {
        return _routePassengers_probability3_xjal( this, ped );
      }
      @Override
      public double probability4( Agent ped ) {
        return _routePassengers_probability4_xjal( this, ped );
      }
      @Override
      public double probability5( Agent ped ) {
        return _routePassengers_probability5_xjal( this, ped );
      }
	};
    
    return _result_xjal;
  }

  /**
   * Setups parameters of an embedded object instance<br>
   * This method should not be called by user
   */
  private void setupParameters_routePassengers_xjal( final com.anylogic.libraries.pedestrian.PedSelectOutput<Agent> self, TableInput _t ) {
    self.type = self._type_DefaultValue_xjal();
  }

  /**
   * Setups an embedded object instance<br>
   * This method should not be called by user
   */
  @AnyLogicInternalCodegenAPI
  private void doBeforeCreate_routePassengers_xjal( com.anylogic.libraries.pedestrian.PedSelectOutput<Agent> self, TableInput _t ) {
  }

  private TargetLine _inflowSource_locationLine_xjal( final com.anylogic.libraries.pedestrian.PedSource<Agent> self, Agent ped ) {
    TargetLine _value;
    _value = 
entryLine 
;
    return _value;
  }
  private TargetLine _goToTrains_locationLine_xjal( final com.anylogic.libraries.pedestrian.PedGoTo<Agent> self, Agent ped ) {
    TargetLine _value;
    _value = 
exitLine 
;
    return _value;
  }
  private double _atTM_delayTime_xjal( final com.anylogic.libraries.pedestrian.PedService<Agent> self, ServiceUnit service, Agent ped ) {
    double _value;
    _value = 
triangular(7,12,40) 
;
    return _value;
  }
  private double _routePassengers_probability1_xjal( final com.anylogic.libraries.pedestrian.PedSelectOutput<Agent> self, Agent ped ) {
    double _value;
    _value = 
0.8 
;
    return _value;
  }
  private double _routePassengers_probability3_xjal( final com.anylogic.libraries.pedestrian.PedSelectOutput<Agent> self, Agent ped ) {
    double _value;
    _value = 
0 
;
    return _value;
  }
  private double _routePassengers_probability4_xjal( final com.anylogic.libraries.pedestrian.PedSelectOutput<Agent> self, Agent ped ) {
    double _value;
    _value = 
0 
;
    return _value;
  }
  private double _routePassengers_probability5_xjal( final com.anylogic.libraries.pedestrian.PedSelectOutput<Agent> self, Agent ped ) {
    double _value;
    _value = 
0 
;
    return _value;
  }
  // Functions

  public 
String 
 toString(  ) { 

return super.toString(); 
  }
  // View areas
  public ViewArea _origin_VA = new ViewArea( this, "[Origin]", 0, 0, 1000.0, 600.0 );
  @Override
  @AnyLogicInternalCodegenAPI
  public int getViewAreas(Map<String, ViewArea> _output) {
    if ( _output != null ) {
      _output.put( "_origin_VA", this._origin_VA );
    }
    return 1 + super.getViewAreas( _output );
  }
  @AnyLogicInternalCodegenAPI
  protected static final int _image = 1;
  @AnyLogicInternalCodegenAPI
  protected static final int _wall = 2;
  @AnyLogicInternalCodegenAPI
  protected static final int _entryLine = 3;
  @AnyLogicInternalCodegenAPI
  protected static final int _exitLine = 4;
  @AnyLogicInternalCodegenAPI
  protected static final int _queueLine = 5;
  @AnyLogicInternalCodegenAPI
  protected static final int _queueLine1 = 6;
  @AnyLogicInternalCodegenAPI
  protected static final int _servicePoint = 7;
  @AnyLogicInternalCodegenAPI
  protected static final int _servicePoint1 = 8;
  @AnyLogicInternalCodegenAPI
  protected static final int _servicePoint2 = 9;
  @AnyLogicInternalCodegenAPI
  protected static final int _servicePoint3 = 10;
  @AnyLogicInternalCodegenAPI
  protected static final int _servicePoint4 = 11;
  @AnyLogicInternalCodegenAPI
  protected static final int _servicePoint5 = 12;
  @AnyLogicInternalCodegenAPI
  protected static final int _queueLine2 = 13;
  @AnyLogicInternalCodegenAPI
  protected static final int _queueLine3 = 14;
  @AnyLogicInternalCodegenAPI
  protected static final int _queueLine4 = 15;
  @AnyLogicInternalCodegenAPI
  protected static final int _queueLine5 = 16;
  @AnyLogicInternalCodegenAPI
  protected static final int _fareGates = 17;
  @AnyLogicInternalCodegenAPI
  protected static final int _queueLine6 = 18;
  @AnyLogicInternalCodegenAPI
  protected static final int _queueLine7 = 19;
  @AnyLogicInternalCodegenAPI
  protected static final int _servicePoint6 = 20;
  @AnyLogicInternalCodegenAPI
  protected static final int _servicePoint7 = 21;
  @AnyLogicInternalCodegenAPI
  protected static final int _servicePoint8 = 22;
  @AnyLogicInternalCodegenAPI
  protected static final int _servicePoint9 = 23;
  @AnyLogicInternalCodegenAPI
  protected static final int _servicePoint10 = 24;
  @AnyLogicInternalCodegenAPI
  protected static final int _servicePoint11 = 25;
  @AnyLogicInternalCodegenAPI
  protected static final int _servicePoint12 = 26;
  @AnyLogicInternalCodegenAPI
  protected static final int _queueLine8 = 27;
  @AnyLogicInternalCodegenAPI
  protected static final int _queueLine9 = 28;
  @AnyLogicInternalCodegenAPI
  protected static final int _queueLine10 = 29;
  @AnyLogicInternalCodegenAPI
  protected static final int _queueLine11 = 30;
  @AnyLogicInternalCodegenAPI
  protected static final int _queueLine12 = 31;
  @AnyLogicInternalCodegenAPI
  protected static final int _ticketMachines = 32;
  @AnyLogicInternalCodegenAPI
  protected static final int _densityMap = 33;

  /** Internal constant, shouldn't be accessed by user */
  @AnyLogicInternalCodegenAPI
  protected static final int _SHAPE_NEXT_ID_xjal = 34;

  @AnyLogicInternalCodegenAPI
  public boolean isPublicPresentationDefined() {
    return true;
  }

  @AnyLogicInternalCodegenAPI
  public boolean isEmbeddedAgentPresentationVisible( Agent _a ) {
    return super.isEmbeddedAgentPresentationVisible( _a );
  }
  @AnyLogicInternalCodegenAPI
  private void _initialize_level_xjal() {
	  level.addAll(image, wall, entryLine, exitLine, fareGates, ticketMachines, densityMap);
  }
  @AnyLogicInternalCodegenAPI
  private static MarkupSegment[] _wall_segments_xjal() {
    return new MarkupSegment[] {
       new MarkupSegmentLine( 140.0, 140.0, 0.0, 420.0, 140.0, 0.0 ),
       new MarkupSegmentArc( 420.0, 140.0, 0.0, 450.0, 120.0, 0.0, 1.5707963267948966, 4.71238898038469, 0.4166666666666667,
			420.0, 135.19230769230768, 4.807692307692308, -4.71238898038469, -1.1760052070951335,
			450.0, 147.6923076923077, 27.692307692307704, -2.746801533890032, 1.176005207095135 ),
       new MarkupSegmentLine( 450.0, 120.0, 0.0, 580.0, 120.0, 0.0 ),
       new MarkupSegmentLine( 580.0, 120.0, 0.0, 580.0, 290.0, 0.0 ),
       new MarkupSegmentLine( 580.0, 290.0, 0.0, 450.0, 290.0, 0.0 ),
       new MarkupSegmentArc( 450.0, 290.0, 0.0, 420.0, 270.0, 0.0, 4.71238898038469, 2.214297435588181, 0.5,
			450.0, 268.02543469362104, 21.97456530637899, -4.71238898038469, 0.852674656200364,
			367.26104326469044, 340.31860898041276, 87.89826122551595, -0.7181216705945316, -0.20917354740708083 ),
       new MarkupSegmentLine( 420.0, 270.0, 0.0, 140.0, 270.0, 0.0 ),
       new MarkupSegmentLine( 140.0, 270.0, 0.0, 140.0, 140.0, 0.0 ), };
  }
  @AnyLogicInternalCodegenAPI
  protected static final double[] _entryLine_pointsDX_xjal() {
    return new double[] { 0.0, 0.0,  };
  }

  @AnyLogicInternalCodegenAPI
  protected static final double[] _entryLine_pointsDY_xjal() {
    return new double[] { 0.0, -90.0,  };
  }
  @AnyLogicInternalCodegenAPI
  protected static final double[] _exitLine_pointsDX_xjal() {
    return new double[] { 0.0, 0.0,  };
  }

  @AnyLogicInternalCodegenAPI
  protected static final double[] _exitLine_pointsDY_xjal() {
    return new double[] { 0.0, -140.0,  };
  }
  @AnyLogicInternalCodegenAPI
  private static MarkupSegment[] _queueLine_segments_xjal() {
    return new MarkupSegment[] {
   new MarkupSegmentLine( 460.0, 143.073, 0.0, 520.0, 143.073, 0.0) };
  }
  @AnyLogicInternalCodegenAPI
  private static MarkupSegment[] _queueLine1_segments_xjal() {
    return new MarkupSegment[] {
   new MarkupSegmentLine( 460.0, 165.495, 0.0, 520.0, 165.495, 0.0) };
  }
  @AnyLogicInternalCodegenAPI
  private static MarkupSegment[] _queueLine2_segments_xjal() {
    return new MarkupSegment[] {
   new MarkupSegmentLine( 460.0, 187.918, 0.0, 520.0, 187.918, 0.0) };
  }
  @AnyLogicInternalCodegenAPI
  private static MarkupSegment[] _queueLine3_segments_xjal() {
    return new MarkupSegment[] {
   new MarkupSegmentLine( 460.0, 210.34, 0.0, 520.0, 210.34, 0.0) };
  }
  @AnyLogicInternalCodegenAPI
  private static MarkupSegment[] _queueLine4_segments_xjal() {
    return new MarkupSegment[] {
   new MarkupSegmentLine( 460.0, 232.762, 0.0, 520.0, 232.762, 0.0) };
  }
  @AnyLogicInternalCodegenAPI
  private static MarkupSegment[] _queueLine5_segments_xjal() {
    return new MarkupSegment[] {
   new MarkupSegmentLine( 460.0, 255.185, 0.0, 520.0, 255.185, 0.0) };
  }
  @AnyLogicInternalCodegenAPI
  private static MarkupSegment[] _queueLine6_segments_xjal() {
    return new MarkupSegment[] {
   new MarkupSegmentLine( 281.486, 226.299, 0.0, 281.486, 174.62900000000002, 0.0) };
  }
  @AnyLogicInternalCodegenAPI
  private static MarkupSegment[] _queueLine7_segments_xjal() {
    return new MarkupSegment[] {
   new MarkupSegmentLine( 302.492, 226.299, 0.0, 302.492, 174.62900000000002, 0.0) };
  }
  @AnyLogicInternalCodegenAPI
  private static MarkupSegment[] _queueLine8_segments_xjal() {
    return new MarkupSegment[] {
   new MarkupSegmentLine( 323.499, 226.299, 0.0, 323.499, 174.62900000000002, 0.0) };
  }
  @AnyLogicInternalCodegenAPI
  private static MarkupSegment[] _queueLine9_segments_xjal() {
    return new MarkupSegment[] {
   new MarkupSegmentLine( 344.505, 226.299, 0.0, 344.505, 174.62900000000002, 0.0) };
  }
  @AnyLogicInternalCodegenAPI
  private static MarkupSegment[] _queueLine10_segments_xjal() {
    return new MarkupSegment[] {
   new MarkupSegmentLine( 365.512, 226.299, 0.0, 365.512, 174.62900000000002, 0.0) };
  }
  @AnyLogicInternalCodegenAPI
  private static MarkupSegment[] _queueLine11_segments_xjal() {
    return new MarkupSegment[] {
   new MarkupSegmentLine( 386.519, 226.299, 0.0, 386.519, 174.62900000000002, 0.0) };
  }
  @AnyLogicInternalCodegenAPI
  private static MarkupSegment[] _queueLine12_segments_xjal() {
    return new MarkupSegment[] {
   new MarkupSegmentLine( 407.525, 226.299, 0.0, 407.525, 174.62900000000002, 0.0) };
  }

  protected ShapeImage image;
  protected Wall wall;
  protected TargetLine entryLine;
  protected TargetLine exitLine;
  protected QueuePath queueLine;
  protected QueuePath queueLine1;
  protected ServicePoint<QueuePath> servicePoint;
  protected ServicePoint<QueuePath> servicePoint1;
  protected ServicePoint<QueuePath> servicePoint2;
  protected ServicePoint<QueuePath> servicePoint3;
  protected ServicePoint<QueuePath> servicePoint4;
  protected ServicePoint<QueuePath> servicePoint5;
  protected QueuePath queueLine2;
  protected QueuePath queueLine3;
  protected QueuePath queueLine4;
  protected QueuePath queueLine5;
  protected ServiceWLine<ServicePoint<QueuePath>> fareGates;
  protected QueuePath queueLine6;
  protected QueuePath queueLine7;
  protected ServicePoint<QueuePath> servicePoint6;
  protected ServicePoint<QueuePath> servicePoint7;
  protected ServicePoint<QueuePath> servicePoint8;
  protected ServicePoint<QueuePath> servicePoint9;
  protected ServicePoint<QueuePath> servicePoint10;
  protected ServicePoint<QueuePath> servicePoint11;
  protected ServicePoint<QueuePath> servicePoint12;
  protected QueuePath queueLine8;
  protected QueuePath queueLine9;
  protected QueuePath queueLine10;
  protected QueuePath queueLine11;
  protected QueuePath queueLine12;
  protected ServiceWLine<ServicePoint<QueuePath>> ticketMachines;
  protected DensityMap densityMap;
  protected com.anylogic.engine.markup.Level level;

  private com.anylogic.engine.markup.Level[] _getLevels_xjal;

  @Override
  public com.anylogic.engine.markup.Level[] getLevels() {
    return _getLevels_xjal;
  }

  @AnyLogicInternalCodegenAPI
  private void _createPersistentElementsBP0_xjal() {
    image = new ShapeImage(
		Main.this, SHAPE_DRAW_2D3D, true, 140.0, 120.0, 0.0, 0.0, 
			440.0, 170.0, "/subwaystation/", 
			new String[]{"image1.png",}	 );

    wall = new Wall( this, SHAPE_DRAW_2D3D, true, WALL_FILL_NONE, blue, 2.0, 20.0, _wall_segments_xjal() );

    entryLine = new TargetLine( this, SHAPE_DRAW_2D, true, 150.0, 250.0, _entryLine_pointsDX_xjal(), _entryLine_pointsDY_xjal(), green );

    exitLine = new TargetLine( this, SHAPE_DRAW_2D, true, 570.0, 270.0, _exitLine_pointsDX_xjal(), _exitLine_pointsDY_xjal(), green );

    queueLine = new QueuePath( EXCEEDED_QUEUE_EXTEND_TO_THE_FREE_SPACE, _queueLine_segments_xjal() );

    queueLine1 = new QueuePath( EXCEEDED_QUEUE_EXTEND_TO_THE_FREE_SPACE, _queueLine1_segments_xjal() );

    servicePoint = new ServicePoint<QueuePath>(540.0, 143.073, 0.0, null );

    servicePoint1 = new ServicePoint<QueuePath>(540.0, 165.495, 0.0, null );

    servicePoint2 = new ServicePoint<QueuePath>(540.0, 187.918, 0.0, null );

    servicePoint3 = new ServicePoint<QueuePath>(540.0, 210.34, 0.0, null );

    servicePoint4 = new ServicePoint<QueuePath>(540.0, 232.762, 0.0, null );

    servicePoint5 = new ServicePoint<QueuePath>(540.0, 255.185, 0.0, null );

    queueLine2 = new QueuePath( EXCEEDED_QUEUE_EXTEND_TO_THE_FREE_SPACE, _queueLine2_segments_xjal() );

    queueLine3 = new QueuePath( EXCEEDED_QUEUE_EXTEND_TO_THE_FREE_SPACE, _queueLine3_segments_xjal() );

    queueLine4 = new QueuePath( EXCEEDED_QUEUE_EXTEND_TO_THE_FREE_SPACE, _queueLine4_segments_xjal() );

    queueLine5 = new QueuePath( EXCEEDED_QUEUE_EXTEND_TO_THE_FREE_SPACE, _queueLine5_segments_xjal() );

    queueLine6 = new QueuePath( EXCEEDED_QUEUE_EXTEND_TO_THE_FREE_SPACE, _queueLine6_segments_xjal() );

    queueLine7 = new QueuePath( EXCEEDED_QUEUE_EXTEND_TO_THE_FREE_SPACE, _queueLine7_segments_xjal() );

    servicePoint6 = new ServicePoint<QueuePath>(281.486, 157.405, 4.71238898038469, null );

    servicePoint7 = new ServicePoint<QueuePath>(302.492, 157.405, 4.71238898038469, null );

    servicePoint8 = new ServicePoint<QueuePath>(323.499, 157.405, 4.71238898038469, null );

    servicePoint9 = new ServicePoint<QueuePath>(344.505, 157.405, 4.71238898038469, null );

    servicePoint10 = new ServicePoint<QueuePath>(365.512, 157.405, 4.71238898038469, null );

    servicePoint11 = new ServicePoint<QueuePath>(386.519, 157.405, 4.71238898038469, null );

    servicePoint12 = new ServicePoint<QueuePath>(407.525, 157.405, 4.71238898038469, null );

    queueLine8 = new QueuePath( EXCEEDED_QUEUE_EXTEND_TO_THE_FREE_SPACE, _queueLine8_segments_xjal() );

    queueLine9 = new QueuePath( EXCEEDED_QUEUE_EXTEND_TO_THE_FREE_SPACE, _queueLine9_segments_xjal() );

    queueLine10 = new QueuePath( EXCEEDED_QUEUE_EXTEND_TO_THE_FREE_SPACE, _queueLine10_segments_xjal() );

    queueLine11 = new QueuePath( EXCEEDED_QUEUE_EXTEND_TO_THE_FREE_SPACE, _queueLine11_segments_xjal() );

    queueLine12 = new QueuePath( EXCEEDED_QUEUE_EXTEND_TO_THE_FREE_SPACE, _queueLine12_segments_xjal() );

    densityMap = new DensityMap( this, SHAPE_DRAW_2D, true, 620.0, 110.0, 10.0, 200.0, 0.25, 1.5, DENSITY_VALUE_MAX, false, 300.0, true,
             PEDESTRIAN_MAP_TYPE, LOGARITHMIC_COLOR_SCHEME );

    fareGates = new ServiceWLine<ServicePoint<QueuePath>>(this, SHAPE_DRAW_2D3D, true, SERVICE_TYPE_POINT, false,
        new ServicePoint[] { servicePoint, servicePoint1, servicePoint2, servicePoint3, servicePoint4, servicePoint5, },
        new QueuePath[] { queueLine, queueLine1, queueLine2, queueLine3, queueLine4, queueLine5, }, null,
        SERVICE_QUEUE_CLOSEST_STRICT, false, green, green, magenta, SERVICE_GROUP_BEHAVIOR_SAME_FOR_ALL_GROUPS, SERVICE_GROUP_INDIVIDUAL_SERVING, null );

    ticketMachines = new ServiceWLine<ServicePoint<QueuePath>>(this, SHAPE_DRAW_2D3D, true, SERVICE_TYPE_POINT, false,
        new ServicePoint[] { servicePoint6, servicePoint7, servicePoint8, servicePoint9, servicePoint10, servicePoint11, servicePoint12, },
        new QueuePath[] { queueLine6, queueLine7, queueLine8, queueLine9, queueLine10, queueLine11, queueLine12, }, null,
        SERVICE_QUEUE_CLOSEST_STRICT, false, green, green, magenta, SERVICE_GROUP_BEHAVIOR_SAME_FOR_ALL_GROUPS, SERVICE_GROUP_INDIVIDUAL_SERVING, null );

  }

  @AnyLogicInternalCodegenAPI
  private void _createPersistentElementsAP0_xjal() {
  }

  @AnyLogicInternalCodegenAPI
  private void _createPersistentElementsBS0_xjal() {
  }


  // Static initialization of persistent elements
  private void instantiatePersistentElements_xjal() {
    level = new com.anylogic.engine.markup.Level(this, "level", SHAPE_DRAW_2D3D, 0.0, true, true);  			
	_getLevels_xjal = new com.anylogic.engine.markup.Level[] { 
      level };
    _createPersistentElementsBP0_xjal();
  }
  protected ShapeTopLevelPresentationGroup presentation;
  protected ShapeModelElementsGroup icon; 

  @Override
  @AnyLogicInternalCodegenAPI
  public ShapeTopLevelPresentationGroup getPresentationShape() {
    return presentation;
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public ShapeModelElementsGroup getModelElementsShape() {
    return icon;
  }

	


  /**
   * Constructor
   */
  public Main( Engine engine, Agent owner, AgentList<? extends Main> ownerPopulation ) {
    super( engine, owner, ownerPopulation );
    instantiateBaseStructureThis_xjal();
  }

  @AnyLogicInternalCodegenAPI
  public void onOwnerChanged_xjal() {
    super.onOwnerChanged_xjal();
    setupReferences_xjal();
  }

  @AnyLogicInternalCodegenAPI
  public void instantiateBaseStructure_xjal() {
    super.instantiateBaseStructure_xjal();
    instantiateBaseStructureThis_xjal();
  }
  
  @AnyLogicInternalCodegenAPI
  private void instantiateBaseStructureThis_xjal() {
    inflowSource = instantiate_inflowSource_xjal();
    inflowSink = instantiate_inflowSink_xjal();
    goToTrains = instantiate_goToTrains_xjal();
    pedService = instantiate_pedService_xjal();
    atTM = instantiate_atTM_xjal();
    routePassengers = instantiate_routePassengers_xjal();
	instantiatePersistentElements_xjal();
    setupReferences_xjal();
  }
  
  @AnyLogicInternalCodegenAPI
  private void setupReferences_xjal() {
  }
  
  /**
   * Simple constructor. Please add created agent to some population by calling goToPopulation() function
   */
  public Main() {
  }
  
  /**
   * Creating embedded object instances
   */
  @AnyLogicInternalCodegenAPI
  private void instantiatePopulations_xjal() {
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public void doCreate() {
    super.doCreate();
    // Creating embedded object instances
    instantiatePopulations_xjal();
    // Assigning initial values for plain variables
    setupPlainVariables_Main_xjal();
    // Dynamic initialization of persistent elements
    _createPersistentElementsAP0_xjal();
	_initialize_level_xjal();
    level.initialize();
    presentation = new ShapeTopLevelPresentationGroup( Main.this, true, 0, 0, 0, 0 , level );
    // Creating embedded object instances
    instantiatePopulations_xjal();
    icon = new ShapeModelElementsGroup( Main.this, getElementProperty( "subwaystation.Main.icon", IElementDescriptor.MODEL_ELEMENT_DESCRIPTORS )  );
    icon.setIconOffsets( 0.0, 0.0 );
    // Creating non-replicated embedded objects
    setupParameters_inflowSource_xjal( inflowSource, null );
    doBeforeCreate_inflowSource_xjal( inflowSource, null );
    inflowSource.createAsEmbedded();
    setupParameters_inflowSink_xjal( inflowSink, null );
    doBeforeCreate_inflowSink_xjal( inflowSink, null );
    inflowSink.createAsEmbedded();
    setupParameters_goToTrains_xjal( goToTrains, null );
    doBeforeCreate_goToTrains_xjal( goToTrains, null );
    goToTrains.createAsEmbedded();
    setupParameters_pedService_xjal( pedService, null );
    doBeforeCreate_pedService_xjal( pedService, null );
    pedService.createAsEmbedded();
    setupParameters_atTM_xjal( atTM, null );
    doBeforeCreate_atTM_xjal( atTM, null );
    atTM.createAsEmbedded();
    setupParameters_routePassengers_xjal( routePassengers, null );
    doBeforeCreate_routePassengers_xjal( routePassengers, null );
    routePassengers.createAsEmbedded();
	 // Port connectors with non-replicated objects
    inflowSink.in.connect( goToTrains.out ); // connector1
    pedService.out.connect( goToTrains.in ); // connector2
    routePassengers.out1.connect( pedService.in ); // connector
    routePassengers.in.connect( inflowSource.out ); // connector3
    atTM.in.connect( routePassengers.out2 ); // connector4
    goToTrains.in.connect( atTM.out ); // connector5
    // Creating replicated embedded objects
    setupInitialConditions_xjal( Main.class );
    // Dynamic initialization of persistent elements
    _createPersistentElementsBS0_xjal();
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public void doStart() {
    super.doStart();
    inflowSource.startAsEmbedded();
    inflowSink.startAsEmbedded();
    goToTrains.startAsEmbedded();
    pedService.startAsEmbedded();
    atTM.startAsEmbedded();
    routePassengers.startAsEmbedded();
  }
 

  /**
   * Assigning initial values for plain variables<br>
   * <em>This method isn't designed to be called by user and may be removed in future releases.</em>
   */
  @AnyLogicInternalCodegenAPI
  public void setupPlainVariables_xjal() {
    setupPlainVariables_Main_xjal();
  }

  /**
   * Assigning initial values for plain variables<br>
   * <em>This method isn't designed to be called by user and may be removed in future releases.</em>
   */
  @AnyLogicInternalCodegenAPI
  private void setupPlainVariables_Main_xjal() {
  }

  // User API -----------------------------------------------------
  @AnyLogicInternalCodegenAPI
  public static LinkToAgentAnimationSettings _connections_commonAnimationSettings_xjal = new LinkToAgentAnimationSettingsImpl( false, black, 1.0, LINE_STYLE_SOLID, ARROW_NONE, 0.0 );

  public LinkToAgentCollection<Agent, Agent> connections = new LinkToAgentStandardImpl<Agent, Agent>(this, _connections_commonAnimationSettings_xjal);
  @Override
  public LinkToAgentCollection<? extends Agent, ? extends Agent> getLinkToAgentStandard_xjal() {
    return connections;
  }


  @AnyLogicInternalCodegenAPI
  public void drawLinksToAgents(boolean _underAgents_xjal, LinkToAgentAnimator _animator_xjal) {
    super.drawLinksToAgents(_underAgents_xjal, _animator_xjal);
    if ( _underAgents_xjal ) {
      _animator_xjal.drawLink( this, connections, true, true );
    }
  }

  public List<Object> getEmbeddedObjects() {
    List<Object> list = super.getEmbeddedObjects();
    if (list == null) {
      list = new LinkedList<Object>();
    }
    list.add( inflowSource );
    list.add( inflowSink );
    list.add( goToTrains );
    list.add( pedService );
    list.add( atTM );
    list.add( routePassengers );
    return list;
  }

  public AgentList<? extends Main> getPopulation() {
    return (AgentList<? extends Main>) super.getPopulation();
  }

  public List<? extends Main> agentsInRange( double distance ) {
    return (List<? extends Main>) super.agentsInRange( distance );
  }

  @AnyLogicInternalCodegenAPI
  public void onDestroy() {
    inflowSource.onDestroy();
    inflowSink.onDestroy();
    goToTrains.onDestroy();
    pedService.onDestroy();
    atTM.onDestroy();
    routePassengers.onDestroy();
    fareGates.onDestroy();
    ticketMachines.onDestroy();
    densityMap.onDestroy();
    super.onDestroy();
  }

  @AnyLogicInternalCodegenAPI
  @Override
  public void doFinish() {
    super.doFinish();
    inflowSource.doFinish();
    inflowSink.doFinish();
    goToTrains.doFinish();
    pedService.doFinish();
    atTM.doFinish();
    routePassengers.doFinish();
  }



}