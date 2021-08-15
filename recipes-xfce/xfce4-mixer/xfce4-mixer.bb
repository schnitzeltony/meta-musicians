SUMMARY = "A volume control application based on GStreamer"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=59530bdf33659b29e73d4adb9f9f6552"

inherit xfce-panel-plugin xfce-git

DEPENDS += "gst-plugins-base gtk+3 dbus-glib xfce4-dev-tools-native xfconf"

SRC_URI = "git://gitlab.xfce.org/apps/xfce4-mixer.git"
PV = "4.11.0+git${SRCPV}"
SRCREV = "cfcfd6fd1aaa497b5be421bb05b66526104727d3"
S = "${WORKDIR}/git"

EXTRA_OECONF += "--disable-debug"

FILES:${PN} += "${datadir}/xfce4/mixer"

RDEPENDS:${PN} += " \
    gstreamer \
    gst-plugins-base-playbin \
    gst-plugins-base-decodebin \
    gst-plugins-base-decodebin2 \
    gst-plugins-base-gio \
    gst-plugins-base-alsa \
    gst-plugins-base-volume \
    gst-plugins-base-audioconvert \
    gst-plugins-base-audioresample \
    gst-plugins-base-typefindfunctions \
"
