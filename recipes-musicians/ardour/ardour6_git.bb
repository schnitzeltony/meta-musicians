SUMMARY = "Ardour is a multi-channel digital audio workstation"
HOMEPAGE = "http://ardour.org/"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=4641e94ec96f98fabc56ff9cc48be14b"

DEPENDS += " \
    gettext-native \
    gtk+ \
    gtkmm \
    cppunit \
    jack \
    alsa-lib \
    fftw \
    vamp-plugin-sdk \
    aubio \
    taglib \
    boost \
    virtual/libx11 \
    dssi \
    zlib \
    lrdf \
    rubberband \
    suil \
    lilv \
    libarchive \
    libltc \
    qm-dsp \
    fluidsynth \
    hidapi \
"

inherit waf features_check gtk-icon-cache pkgconfig python3native mime-xdg siteinfo

REQUIRED_DISTRO_FEATURES = "x11"

SRC_URI = "git://github.com/Ardour/ardour.git"
SRCREV = "e4e21f4d073ab00b1a0bb6ff6ca49f28b02fd68a"
PV = "6.6"
S = "${WORKDIR}/git"

# arch specific override - default (tested) is ARM -> no fpu-optimizations
# can be something like i686 / x86_64 see file 'wscript' in sourcepath for more details
BUILD_DIST_TARGET ??= "none"

EXTRA_OECONF = " \
    --configdir=${sysconfdir} \
    --bindir=${bindir} \
    --libdir=${libdir} \
    --optimize \
    --fpu-optimization \
    --freedesktop \
    --cxx11 \
    --no-phone-home \
    --use-external-libs \
    --qm-dsp-include=${STAGING_INCDIR}/qm-dsp \
    \
    --with-backends="jack,alsa" \
    --dist-target=${BUILD_DIST_TARGET} \
"

PATH_append = ":${B}"

# Asking fails - waf supports --bindir / --libdir
waf_preconfigure() {
}

do_configure_prepend() {
    # link python -> python3
    ln -sf `which python3` ${B}/python
}

do_install_append() {
    # install icons to freedesktop locations
    for s in 16 22 32 48 256 512; do
        install -d  ${D}${datadir}/icons/hicolor/${s}x${s}/apps
        ln -s ../../../../${BPN}/resources/Ardour-icon_${s}px.png \
            ${D}${datadir}/icons/hicolor/${s}x${s}/apps/${BPN}.png
    done

    # install .desktop
    install -d  ${D}${datadir}/applications
    install -m 0644 ${B}/gtk2_ardour/ardour6.desktop ${D}${datadir}/applications
}

FILES_${PN}-dev += " \
    ${libdir}/${BPN}/libardour.so \
    ${libdir}/${BPN}/libardouralsautil.so \
    ${libdir}/${BPN}/libaudiographer.so \
    ${libdir}/${BPN}/libcanvas.so \
    ${libdir}/${BPN}/libevoral.so \
    ${libdir}/${BPN}/libgtkmm2ext.so \
    ${libdir}/${BPN}/libmidipp.so \
    ${libdir}/${BPN}/libpbd.so \
    ${libdir}/${BPN}/libptformat.so \
    ${libdir}/${BPN}/libtemporal.so \
    ${libdir}/${BPN}/libwaveview.so \
    ${libdir}/${BPN}/libwidgets.so \
    ${libdir}/${BPN}/vamp/*.so \
"

FILES_${PN}-staticdev += " \
    ${libdir}/${BPN}/*.a \
"

# did not get ardour6 to fly on 32bit systems - so (r)provide for 64 bits only
PROVIDES = "${@oe.utils.conditional('SITEINFO_BITS', '64', 'ardour', '', d)}"
RPROVIDES_${PN} = "${@oe.utils.conditional('SITEINFO_BITS', '64', 'ardour', '', d)}"
